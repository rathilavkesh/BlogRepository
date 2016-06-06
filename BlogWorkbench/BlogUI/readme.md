 
What is Node.js?

	Node.js is a JavaScript runtime built on Chrome's V8 JavaScript engine. Node.js uses an event-driven, non-blocking I/O model that makes it lightweight and efficient.
	Node.js is an open source, cross-platform runtime environment for developing server-side and networking applications. Node.js applications are written in JavaScript, and can be run within the Node.js runtime on OS X, Microsoft Windows, and Linux.
	Originally, it was intended as a server environment for applications, but developers started using it to create tools to aid them in local task automation. Since then, a whole new ecosystem of Node-based tools (such as Grunt and Gulp) has evolved to transform the face of front-end development.

What is NPM?
	To make use of tools (or packages) in Node.js we need to be able to install and manage them in a useful way. This is where npm, the node package manager, comes in. It installs the packages you want to use and provides a useful interface to work with them. 
	npm can install packages in local or global mode. In local mode it installs the package in a node_modules folder in your parent working directory. This location is owned by the current user. Global packages are installed in {prefix}/lib/node_modules/ which is owned by root (where {prefix} is usually /usr/ or /usr/local). 

What is GULP?
	Gulp is a Javascript based tool which allows you to automate bits of your workflow. Gulp is a javascript task runner that lets you automate tasks such as…

	1. Bundling and minifying libraries and stylesheets.
	2. Refreshing your browser when you save a file.
	3. Quickly running unit tests
	4. Running code analysis
	5. Less/Sass to CSS compilation
	6. Copying modified files to an output directory
	and many more
	

Steps to setup development environment:
	1. Install Node.js from below location
		https://nodejs.org/en/
	
	2. Run below command to install Bower and gulp. Bower is a package manager for Javascript libraries such as jQuery, AngularJS, Backbone, Bootstrap etc that allows you to define, version, and retrieve your dependencies.
		
		npm install -g bower gulp-cli
		
	3. Run "npm install" command
	
	4. Run "bower install" command.
