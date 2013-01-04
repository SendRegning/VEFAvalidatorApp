This repository contains the [VEFA Validator Application](http://validator.vefa.difi.no) which is being developed by [Difi](http://www.difi.no).

The validator consists of two Github projects:
*  [VEFAvalidatorApp](https://github.com/difi/VEFAvalidatorApp) - The java application (this project)
*  [VEFAvalidatorConf](https://github.com/difi/VEFAvalidatorConf) - The configuration

To install:
* See [documentation](https://github.com/difi/VEFAvalidatorApp/blob/master/validate-web/src/main/webapp/documentation/Documentation.rtf) for details

Short install version:
* Clone [VEFAvalidatorConf](https://github.com/difi/VEFAvalidatorConf) to /etc/opt/VEFAvalidator
* Clone [VEFAvalidatorApp](https://github.com/difi/VEFAvalidatorApp) to a directory of your choosing

To build:
* At VEFAvalidatorApp: mvn clean install

The build will create a web application and a web service application that can be install in Tomcat or GlassFish. Please refer to the [documentation](https://github.com/difi/VEFAvalidatorApp/blob/master/validate-web/src/main/webapp/documentation/Documentation.rtf) for more information.
