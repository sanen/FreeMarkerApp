	${person.lastName}:${person.firstName}
	
	<!-- freemarker json variable-->
	<#assign jsonVar="{\"name\":\"firstName\",\"lastName\":\"LastName\"}">
	<#assign jsonOutput=jsonVar?eval> 
	${jsonVar?eval.name}:${jsonVar?eval.lastName}
	${jsonOutput.name}:${jsonOutput.lastName}
	
	${1000001223}
	