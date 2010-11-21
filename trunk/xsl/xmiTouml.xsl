<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" xmlns:uml="http://schema.omg.org/spec/UML/2.1">
<xsl:output indent="yes"/>

<xsl:template match="/">
	<xsl:call-template name="model"/>
</xsl:template>

<xsl:template name="model">
	<xsl:for-each select="/xmi:XMI/uml:Model">
		<xsl:copy>
				<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:for-each>
</xsl:template>


<xsl:template match="type" >
	<xsl:if test="@xmi:idref='EAJava_int'">
		<type xmi:type="uml:PrimitiveType" href="pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#Integer"/>
	</xsl:if>
	<xsl:if test="@xmi:idref='EAJava_char'">
		<type xmi:type="uml:PrimitiveType" href="pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#String"/>
	</xsl:if>
	<xsl:if test="@xmi:idref='EAJava_boolean'">
		<type xmi:type="uml:PrimitiveType" href="pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#Boolean"/>
	</xsl:if>
</xsl:template>

<xsl:template match="body" />

<xsl:template match="@*|node()">
	<xsl:copy>
		<xsl:apply-templates select="@*|node()"/>  
	</xsl:copy>
</xsl:template>

</xsl:stylesheet>