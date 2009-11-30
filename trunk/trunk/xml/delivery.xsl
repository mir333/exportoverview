<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : delivery.xsl
    Created on : November 30, 2009, 7:04 PM
    Author     : miro
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>delivery.xsl</title>
            </head>
            <body>
                <xsl:value-of select="Delivery/Client/name"/><br />
                <xsl:value-of select="Delivery/Client/street"/><br />
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
