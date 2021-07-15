# navascript-editor
XText based Navascript 3 editor

## Prerequisites
Following Eclipse Plugins are required
- PDE
- XText

This source has been tested on Eclipse versions 2020-09 and 2020-12.

## Change language definition and test

1. The language definition is Navascript.xtext (found in com.dexels.navajo.xtext.navascript package).
1. Language artifacts are created by clicking on Navascript.xtext and open menu -> Run As -> Generate XText Artifacts.
1. The changes can be tested by opening an new Eclipse application via menu -> Run As -> Eclipse Application on the com.dexels.navajo.xtext.navascript.ide project.

## Export as Eclipse plugin for P2 repository
Use "Export" and then choose

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_0.png?raw=true)

Then set following options and export path accordingly

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_1.png?raw=true)

In Options tab set following options

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_2.png?raw=true)
