/*
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

import com.dexels.navajo.navascript.Expression;
import com.dexels.navajo.navascript.InnerBody;
import com.dexels.navajo.navascript.KeyValueArgument;
import com.dexels.navajo.navascript.KeyValueArguments;
import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.navascript.NavascriptPackage;
import com.dexels.navajo.navascript.PropertyArgument;
import com.dexels.navajo.navascript.PropertyArguments;
import com.dexels.navajo.navascript.TmlIdentifierLiteral;
import com.dexels.navajo.navascript.Var;
import com.dexels.navajo.navascript.impl.AdapterMethodImpl;
import com.dexels.navajo.navascript.impl.FunctionIdentifierImpl;
import com.dexels.navajo.navascript.impl.LoopImpl;
import com.dexels.navajo.navascript.impl.MapImpl;
import com.dexels.navajo.navascript.impl.MappableIdentifierImpl;
import com.dexels.navajo.navascript.impl.MappedArrayFieldImpl;
import com.dexels.navajo.navascript.impl.MappedMessageImpl;
import com.dexels.navajo.navascript.impl.MessageImpl;
import com.dexels.navajo.navascript.impl.PropertyImpl;
import com.dexels.navajo.navascript.impl.SetterFieldImpl;
import com.dexels.navajo.navascript.impl.VarImpl;
import com.dexels.navajo.navigation.NavigationUtils;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;
import com.dexels.navajo.xtext.navascript.navajobridge.OSGIRuntime;
import com.dexels.navajo.xtext.navascript.navajobridge.ProxyFunctionDefinition;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class NavascriptValidator extends AbstractNavascriptValidator implements ServiceListener {

	BundleContext context;

	private static final Logger logger = Logger.getLogger(NavascriptValidator.class);
	
	public NavascriptValidator() {
		context = OSGIRuntime.getDefaultBundleContext();
		context.addServiceListener(this);
		logger.info("In NavascriptValidator: " + context);
	}

	private NavajoProxyStub getNavajoProxyStub() {
		if (  NavajoProxyStub.getInstance() == null ) {
			throw new RuntimeException("NavajoProxyStub not yet activated");
		}
		return  NavajoProxyStub.getInstance();
	}

	@Check
	public void checkFunction(FunctionIdentifierImpl function) {

		String functionName = function.getFunc();
		EList<Expression> arguments = function.getArgs();

		ProxyFunctionDefinition functionDef = getNavajoProxyStub().getFunction(functionName);

		if (functionDef == null) {
			warning("Unknown function: " + functionName, NavascriptPackage.Literals.FUNCTION_IDENTIFIER__FUNC);
			return;
		} 

		List<String> altInputs = functionDef.getInput();
		if ( altInputs.isEmpty() ) { // If there are no inputs specified, return;
			return;
		}
		if ( functionDef.isValidNrInputParameters(arguments.size()) ) {
			return;
		}

		error("Invalid number of input parameters. Valid input: " + functionDef.getInput() , NavascriptPackage.Literals.FUNCTION_IDENTIFIER__ARGS);
	}

	@Check
	public void checkMapDefinition(MapImpl map) {

		String adapterName = map.getAdapterName();
		String objectName = map.getObjectName();

		// If an objectName (old style) is used, ignore check.
		if (objectName != null && !"".equals(objectName)) {
			return;
		}

		if (adapterName != null && !"".equals(adapterName)) {
			if (getNavajoProxyStub().getAdapter(adapterName) == null) {
				warning("Unknown adapter: " + adapterName, NavascriptPackage.Literals.MAP__ADAPTER_NAME);
			}
		}
	}

	private void fieldValidator(EObject mai, String prefix) {
		
		boolean isSetter = false;
		boolean isSetterField = ( mai instanceof SetterFieldImpl );
		if ( mai instanceof SetterFieldImpl ) { // if this is a SetterFieldImpl it can either be a 'setter' or a 'getter'
			SetterFieldImpl sfi = (SetterFieldImpl) mai;
			// If nothing is 'mapped', it is a setter.
			isSetter = sfi.getMappedArray() == null && sfi.getMappedField() == null && sfi.getMappedMessage() == null;
		}		
		String fieldName = NavigationUtils.getFieldFromMappableIdentifier(prefix);
		int level = NavigationUtils.countMappableParentLevel(prefix);
				
		if ( mai.eContainer() instanceof LoopImpl ) { // If current EOBject is a LoopImpl, move one level up.
			mai = mai.eContainer();
		}
		
		EObject parent = NavigationUtils.findFirstMapOrMappedField(mai.eContainer(), level);
	
		AdapterClassDefinition mapdef = NavigationUtils.findAdapterClass(getNavajoProxyStub(), parent);
				
		if (mapdef != null) {

			boolean isValid = ( isSetter ? mapdef.isSetter(fieldName) : mapdef.isGetter(fieldName) );

			
			if (!isValid) {
				if ( mai instanceof LoopImpl ) {
					warning("(1) Unknown mappable field: " + fieldName, NavascriptPackage.Literals.LOOP__MAPPABLE);
					return;
				} else if ( isSetterField ) {
					warning("(2) Unknown mappable field: " + fieldName, NavascriptPackage.Literals.SETTER_FIELD__FIELD);
					return;
				} else {
					warning("(3) Unknown mappable field: " + fieldName, NavascriptPackage.Literals.MAPPABLE_IDENTIFIER__FIELD);
					return;
				}
			}
			
			if ( mai instanceof MappableIdentifierImpl) {
				int numberOfArguments = ((MappableIdentifierImpl) mai).getArgs().size();
				if ( numberOfArguments == 0 ) {
					return;
				}
				List<List<String>> signatures = mapdef.getGetterTypeSignatures(fieldName);
				for (List<String> parameters : signatures) {
					if (parameters.size() == numberOfArguments) {
						return;
					}
				}
			}
			
			if ( mai instanceof SetterFieldImpl) {
				if ( isSetter ) {
					return;
				}
				int numberOfArguments = ((SetterFieldImpl) mai).getArguments().getKeyValueArguments().size();
				if ( numberOfArguments == 0 ) {
					return;
				}
				List<List<String>> signatures = mapdef.getGetterTypeSignatures(fieldName);
				for (List<String> parameters : signatures) {
					if (parameters.size() == numberOfArguments) {
						return;
					}
				}
			}
			
			if ( isSetterField ) {
				error("Invalid number of arguments", NavascriptPackage.Literals.SETTER_FIELD__EXPRESSION_LIST);
			} else {
				error("Invalid number of arguments", NavascriptPackage.Literals.MAPPABLE_IDENTIFIER__ARGS);
			}
		} else {
			if ( isSetterField ) {
				warning("(4) Unknown mappable field: " + fieldName, NavascriptPackage.Literals.SETTER_FIELD__FIELD);
			} else {
				warning("(5) Invalid mappable field: " + fieldName, NavascriptPackage.Literals.MAPPABLE_IDENTIFIER__FIELD);
			}
		}
	}
	
	@Check
	public void checkSetterField(SetterFieldImpl sfi) {
		//System.err.println("In checkSetterField: " + sfi);
		fieldValidator(sfi, sfi.getField());	
	}
	
	@Check
	public void checkMappedMessage(MappedMessageImpl mmi) {
		// No checking need for now I guess.
	}
	
	@Check
	public void checkMappableIdentifier(MappableIdentifierImpl mai) {
		//System.err.println("In checkMappableIdentifier: " + mai);
		fieldValidator(mai, mai.getField());
	}

	private int countPropertiesWithName(String name, EList<EObject> children) {

		int count = 0;

		for (EObject child : children) {
			if (child instanceof PropertyImpl) {
				PropertyImpl prop = (PropertyImpl) child;
				InnerBody ib = NavigationUtils.findInnerBody(prop); // If property has a condition, do not count it.
				if (ib.getCondition() == null && prop.getPropertyName().equals(name)) {
					count++;
				}
			}
			if (!(child instanceof MessageImpl) && child.eContents() != null) {
				count += countPropertiesWithName(name, child.eContents());
			}
		}

		return count;
	}

	/*
	 * Returns true if this message contains this property name.
	 */
	private boolean checkForPropertyName(PropertyImpl checkit, Message m) {
		return countPropertiesWithName(checkit.getPropertyName(), m.eContents()) > 1;
	}

	@Check
	public void checkUniquePropertyName(PropertyImpl property) {
		// Get message.
		Message parent = NavigationUtils.findMessage(property);
		boolean isConstantArrayMessage = parent.getMessageArray() != null && parent.getMessageArray().getArrayMessageElements().size() > 0;
		if ( !isConstantArrayMessage && checkForPropertyName(property, parent)) {
			warning("Duplicate property name in message", NavascriptPackage.Literals.PROPERTY__PROPERTY_NAME);
		}
	}

	@Check
	public void checkUniquePropertyArguments(PropertyImpl property) {

		PropertyArguments arguments = property.getArguments();
		if (arguments != null) {
			EList<PropertyArgument> args = arguments.getArguments();
			Set<String> found = new HashSet<>();
			for ( PropertyArgument pa : args ) {
				if ( found.contains(pa.getClass().getName())) {
					error("Duplicate arguments in property: " + property.getPropertyName(), NavascriptPackage.Literals.PROPERTY__ARGUMENTS);
				}
				found.add(pa.getClass().getName());
			}
		}
	}

//	private boolean findVarDeclaration(EObject root, VarImpl varImpl, TmlIdentifierLiteral tmlLiteral) {
//		
//		
//	}
	
	@Check
	public void checkParameterNameExistence(TmlIdentifierLiteral property) {
	
		EObject rootElement = EcoreUtil2.getRootContainer(property.eContainer());
		EList<EObject> list = rootElement.eContents();
		//System.err.println("List size: " + list.size() + ", rootElement: " + rootElement);
		for ( EObject eo : list ) {
			//System.err.println("eo: " + eo);
			for ( EObject child: eo.eContents() ) {
				//System.err.println("child: " + child);
			}
		}
		Set<String> validVariables = new HashSet<>();
		
		List<VarImpl> candidates = EcoreUtil2.getAllContentsOfType(rootElement, VarImpl.class);
		for ( VarImpl v : candidates) {
			validVariables.add(v.getVarName());
		}
		
		
		String name =  property.getValue().getTml();
		//System.err.println("In checkParameterNameExistence: " + property.getValue().getTml());
		if ( name.startsWith("[/@") ) {
			//System.err.println("In checkParameterNameExistence: " + property.getValue() + " [" + validVariables.size() + ": " + validVariables + "]");
			String stripped = name.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("/@", "");
			if ( !validVariables.contains(stripped) ) {
				//System.err.println("Unknown variable: " + stripped);
				warning("Parameter is not declared", NavascriptPackage.Literals.TML_IDENTIFIER_LITERAL__VALUE);
			}
		}
	}
	
	@Check
	public void checkMappedMappedArrayFieldImpl(MappedArrayFieldImpl maf) {
		String raw = maf.getField();
		int level = NavigationUtils.countMappableParentLevel(raw);
		String field = NavigationUtils.getFieldFromMappableIdentifier(raw);
		EObject eObject = NavigationUtils.findFirstMapOrMappedField(maf.eContainer(), level);
		AdapterClassDefinition map = NavigationUtils.findAdapterClass(getNavajoProxyStub(), eObject);
		if (map != null) {
			boolean isValid = map.isGetter(field);
			if (!isValid) {
				error("Cannot find field: " + field, NavascriptPackage.Literals.MAPPED_ARRAY_FIELD__FIELD);
			}
		} else {
			error("Cannot find adapter for field: " + raw, NavascriptPackage.Literals.MAPPED_ARRAY_FIELD__FIELD);
		}
	}

	@Check
	public void checkAdapterMethodParameters(AdapterMethodImpl am) {

		try {

			EObject eObject = NavigationUtils.findFirstMapOrMappedField(am.eContainer(), 0);
			if (eObject instanceof MapImpl) {
				MapImpl map = (MapImpl) eObject;
				String adapterName = map.getAdapterName();
				if (adapterName == null || "null".equals(adapterName)) {
					warning("Missing adapter definition for method", NavascriptPackage.Literals.ADAPTER_METHOD__METHOD);
					return;
				}

				KeyValueArguments kvas = am.getArguments();

				AdapterClassDefinition mapdef = getNavajoProxyStub().getAdapter(adapterName);

				if (mapdef == null) {
					return;
				}

				List<String> parameters = new ArrayList<>();

				if (kvas != null) {
					for (KeyValueArgument a : kvas.getKeyValueArguments()) {
						parameters.add(a.getKey());
					}
				}

				String methodName = am.getMethod().substring(1);
				Set<String> missing = mapdef.missingRequiredParameters(methodName, parameters);

				Set<String> unknown = mapdef.unknownParameters(methodName, parameters);

				StringBuffer message = new StringBuffer();
				if (missing.size() > 0) {
					message.append("Missing required parameters: " + missing + ". ");
				}
				if (unknown.size() > 0) {
					message.append("Unknown parameters: " + unknown);
				}
				if (missing.size() > 0 || unknown.size() > 0) {
					error(message.toString(), NavascriptPackage.Literals.ADAPTER_METHOD__METHOD);
				}

			} else {

			}
		} catch (Throwable t) {
			logger.error(t);
		}

	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		//
	}
}
