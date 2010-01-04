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
                <title>Document</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                <style type="text/css">
                    h1{
                    text-align:left;
                    margin-left:50px;
                    }
                    #content{
                    width:810px;
                    margin-left:auto;
                    margin-right:auto;
                    border:1px solid gray;
                    }
                    #topDoc{
                    overflow:auto;
                    }
                    #suplier{
                    margin-left:7px;
                    padding:5px;
                    border:1px solid black;
                    width:380px;
                    float:left;
                    }
                    #customer{
                    margin-right:7px;
                    padding:5px;
                    border:1px solid black;
                    width:380px;
                    float:right;
                    }
                    #docLines{
                    padding-top: 5px;
                    width:800px;
                    margin-left:auto;
                    margin-right:auto;
                    min-height: 300px;
                    }
                    .date{
                    float:left;
                    margin-left:30px;
                    }
                    .docNo{
                    float:right;
                    margin-right:30px;
                    }
                    #tableDoc{
                    width:800px;
                    }
                    #bottomDoc{
                    margin:5px;
                    padding:5px;
                    overflow:auto;
                    }
                    #tot1{
                    width:150px;
                    margin-left:130px;
                    }
                    #tot2{
                    width:220px;
                    position:relative;
                    top:-36px;
                    left:330px;
                    }
                    #tot3{
                    width:150px;
                    position:relative;
                    top:-72px;
                    left:600px;
                    }
                    .total{
                    margin:5px;
                    padding:5px;
                    border:1px solid black;
                    }
                </style>
            </head>
            <body>
                <xsl:apply-templates select="Delivery"/>
                <xsl:apply-templates select="Invoice"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Delivery">
        <div id="content">
            <div id="topDoc">
                <h1>Delivery</h1>
                <div id="suplier">
                    <xsl:apply-templates select="UserInfo" />
                </div>
                <div id="customer">
                    <xsl:apply-templates select="Client"/>
                </div>

                <p class="date">
                    Date of issuance: <xsl:value-of select="Totals/date"/>
                </p>
                <p class="docNo">
                    Document No.: <xsl:value-of select="Totals/docNumber"/><br />
                    Payment Type: <xsl:value-of select="Totals/paymentType"/>
                </p>

            </div>
            <div id="docLines">
                <table border="1" id="tableDoc">
                    <thead>
                        <tr>
                            <th>Product Code</th>
                            <th>Product Name</th>
                            <th>Amount</th>
                            <th>Unit price</th>
                            <th>Total price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="DocumentLine">
                            <tr>
                                <td>
                                    <xsl:value-of select="code"/>
                                </td>
                                <td>
                                    <xsl:value-of select="name"/>
                                </td>
                                <td>
                                    <xsl:value-of select="amount"/>
                                </td>
                                <td>
                                    <xsl:value-of select="price"/>
                                </td>
                                <td>
                                    <xsl:value-of select="total"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>

            </div>
            <div id="bottomDoc">

                <div class="total" id="tot3">
                    <b>Total:
                        <xsl:value-of select="Totals/sumVat"/>
                    </b>
                </div>
                <p class="date" style="border-top:1px solid black;width:150px;text-align:center">Suplier</p>
                <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Customer</p>
            </div>
        </div>
    </xsl:template>

    <xsl:template match="Invoice">
        <div id="content">
            <div id="topDoc">
                <h1>Invoice</h1>
                <div id="suplier">
                    <xsl:apply-templates select="UserInfo"/>
                </div>
                <div id="customer">
                    <xsl:apply-templates select="Client"/>
                </div>

                <p class="date">
                    Date of issuance: <xsl:value-of select="Totals/date"/><br />
                    Maturity of bond: <xsl:value-of select="Totals/date"/>
                </p>
                <p class="docNo">
                    Document No.: <xsl:value-of select="Totals/docNumber"/><br />
                    Payment Type: <xsl:value-of select="Totals/paymentType"/>
                </p>

            </div>
            <div id="docLines">
                <table border="1" id="tableDoc">
                    <thead>
                        <tr>
                            <th>Kód produktu</th>
                            <th>Meno produktu</th>
                            <th>Množstvo</th>
                            <th>Cena za kus</th>
                            <th>Celkova cena</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="DocumentLine">
                            <tr>
                                <td>
                                    <xsl:value-of select="code"/>
                                </td>
                                <td>
                                    <xsl:value-of select="name"/>
                                </td>
                                <td>
                                    <xsl:value-of select="amount"/>
                                </td>
                                <td>
                                    <xsl:value-of select="price"/>
                                </td>
                                <td>
                                    <xsl:value-of select="total"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>

            </div>
            <div id="bottomDoc">

                <div class="total" id="tot3">
                    <b>Total:
                        <xsl:value-of select="Totals/sumVat"/>
                    </b>
                </div>
                <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Customer</p>
            </div>
        </div>
    </xsl:template>

    <xsl:template match="UserInfo">
        <big><b><xsl:value-of select="name"/></b></big>
        <br />
        <b>Address:</b>
        <br />
        <xsl:value-of select="street"/>
        <br />
        <xsl:value-of select="zip"/>,
        <xsl:value-of select="city"/>
        <br />
        <xsl:value-of select="country"/>
        <br />
        <b>CRN: </b>
        <xsl:value-of select="ico"/>
        <br />
        <b>DIC: </b>
        <xsl:value-of select="dic"/>
        <br />
        <b>Bank: </b>
        <xsl:value-of select="bank"/>
        <br />
        <b>Account number: </b>
        <xsl:value-of select="bankNo"/>
        <br />
        <b>ISBAN: </b>
        <xsl:value-of select="isban"/>
        <br />
        <b>SWIFT: </b>
        <xsl:value-of select="swift"/>
    </xsl:template>

    <xsl:template match="Client">
        <big><b><xsl:value-of select="name"/></b></big>
        <br />
        <b>Address:</b>
        <br />
        <xsl:value-of select="street"/>
        <br />
        <xsl:value-of select="zip"/>
        <xsl:value-of select="city"/>
        <br />
        <xsl:value-of select="country"/>
        <br />
        <b>CRN: </b>
        <xsl:value-of select="ico"/>
        <br />
        <b>DIC: </b>
        <xsl:value-of select="dic"/>
    </xsl:template>
</xsl:stylesheet>
