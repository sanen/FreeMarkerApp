<#-- Send Email Template -->

<#list recepientList as recp>

To: ${recp.recipient},
    ${recp.address}

Dear ${recp.recipient},

Thank you for your interest in our products. We will be sending you a catalog shortly.
To take advantage of our free gift offer, please fill in the survey attached to this 
letter and return it to the address on the reverse. Only one participant is allowed 
for each household.


Sincere salutations,
ABC Pvt. Ltd.

</#list>
