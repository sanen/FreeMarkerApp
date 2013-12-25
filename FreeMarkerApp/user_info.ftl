<#-- JSON Output -->

{ 
 "recipients": [
	<#list doc.recipients.person as recipient>
	 {		
		"name": "${recipient.name}",
	  	"address": "${recipient.address}"
	 }<#if recipient_has_next>,</#if> 		
	</#list>
  ]
}



         