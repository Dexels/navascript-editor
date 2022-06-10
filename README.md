# navascript-editor
XText based Navascript 3 Editor

## Introduction
This repository can be used in two different ways:

1. for using the features of the Navascript 3 Editor
1. for extending and modifying the Navascript 3 Editor itself

Both forms will be described below.

## Using the Navascript 3 Editor
In the subdirectory _release_ a zipfile with the latest version of the Navascript 3 Editor can be found.
Unpack this file on your system. Then open Eclipse and go to Help -> Install New Software. Click on
**Add** followed by **Local** and select the directory that was created by unpacking the zipfile. The rest
should be self-explaining. After a restart of Eclipse the editor should be available.

Navascript 3 files that were opened in Eclipse prior to the installation of the editor should
be closed and re-opened to use the syntax highlighting and other features from the editor.

The remainder of this file is only relevant if changes to the Navascript 3 Editor itself are needed.

## Prerequisites
Following Eclipse Plugins are required
- PDE
- XText

The source has been tested on Eclipse versions 2022-03 and various platforms, including macOS, Windows 10 and Linux.

## Change language definition and test

The language definition is specified in the file Navascript.xtext in the com.dexels.navajo.xtext.navascript package.

Language artifacts are created by clicking on Navascript.xtext and then, in the Project Explorer, select Run As -> Generate XText Artifacts.
After a fresh clone a lot of Java problems will be reported. These can easily be solved by generating de XText artifacts.
When doing so the following message will probably appear

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/error_message.png?raw=true)

This can be ignored. Just proceed and after a few moments all errors should have been resolved.

The changes can be tested by opening a new Eclipse application by selecting the com.dexels.navajo.xtext.navascript.ide
project in the Project Explorer followed by selecting the menu Run As -> Eclipse Application.

## Export as Eclipse plugin for P2 repository
Before generating a new export increase the version number of the plugin in the files _feature.xml_ and _category.xml_
that are located in the com.dexels.navajo.xtext.navascript.editor.feature project.

To create a new Navascript 3 Editor plugin use File -> Export and then choose

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_0.png?raw=true)

Then set the following options and specify the path for the export

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_1.png?raw=true)

In the Options tab set the following options

![alt text](https://github.com/Dexels/navascript-editor/blob/main/blob/export_feature_2.png?raw=true)

After the last step the export will be generated. Finally pack the entire export directory and it's contents in a new zipfile
and add it to the _release_ directory.
