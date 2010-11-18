<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:uml="http://schema.omg.org/spec/UML/2.1" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
<xsl:output indent="yes"/>

<xsl:template match="uml:Model">
	<xsl:copy>
    	<xsl:copy-of select="@*|node()"/>
    </xsl:copy>
</xsl:template>
<xsl:template match="body">
</xsl:template>
</xsl:stylesheet>