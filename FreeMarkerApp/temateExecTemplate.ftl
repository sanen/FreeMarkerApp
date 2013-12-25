	<#assign x = "plain">
	1. ${x} <#-- 这里是普通变量 -->
	<@test/>
	6. ${x} <#-- 普通变量的值没有被改变 -->
	<#list ["loop"] as x>
	7. ${x} <#-- 现在循环变量隐藏了普通变量 -->
	<#assign x = "plain2"> <#-- 替换普通变量, 隐藏在这里不起作用-->
	
	8. ${x} <#-- 它仍然隐藏普通变量 -->
	</#list>
	9. ${x} <#-- 普通变量的新值 -->
	
	<#-- this is a freemarker macro functions-->
	<#macro test>
	2. ${x}  <#--test宏 --> <#-- 这里我们仍然看到的是普通变量 -->
	<#local x = "local">
	
	3. ${x} <#-- 现在局部变量隐藏了它 -->
	<#list ["loop"] as x>
	4. ${x} <#-- 现在循环变量隐藏了局部变量 -->
	</#list>
	5. ${x} <#-- 现在又可以看到局部变量了 -->
	</#macro>

         