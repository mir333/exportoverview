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

    <xsl:template match="/Delivery">
        <html>
            <head>
                <title>Delivery</title>
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
    width:800px;
    margin-left:auto;
    margin-right:auto;
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
                        <div id="content">
                            <div id="topDoc">
                                <h1>Delivery</h1>
                                <div id="suplier">
                                     Name:
                                    <xsl:value-of select="UserInfo/name"/>
                                    <br />
                                     Street nad No.:
                                    <xsl:value-of select="UserInfo/street"/>
                                    <br />
                                     Zip and city:
                                    <xsl:value-of select="UserInfo/zip"/>
                                    <xsl:value-of select="UserInfo/city"/>
                                    <br />
                                     Country:
                                    <xsl:value-of select="UserInfo/country"/>
                                    <br />
                                     CRN
                                    <xsl:value-of select="UserInfo/ico"/>
                                    <br />
                                     DIC:
                                    <xsl:value-of select="UserInfo/dic"/>
                                    <br />
                                    Banking institution:
                                    <xsl:value-of select="UserInfo/bank"/>
                                    <br />
                                     Account number:
                                    <xsl:value-of select="UserInfo/bankNo"/>
                                    <br />
                                </div>
                                <div id="customer">
                                    Name:
                                    <xsl:value-of select="Client/name"/>
                                    <br />
                                    Street nad No.: 
                                    <xsl:value-of select="Client/street"/>
                                    <br />
                                    Zip and city: 
                                    <xsl:value-of select="Client/zip"/>
                                    <xsl:value-of select="Client/city"/>
                                    <br />
                                    Country: 
                                    <xsl:value-of select="Client/country"/>
                                    <br />
                                    CRN 
                                    <xsl:value-of select="Client/ico"/>
                                    <br />
                                    DIC: 
                                    <xsl:value-of select="Client/dic"/>
                                </div>

                                <p class="date">Date of issuance:
                                    <xsl:value-of select="Totals/date"/>
                                </p>
                                <p class="docNo">Document No.:
                                    <xsl:value-of select="Totals/docNumber"/>
                                </p>

                            </div>
                            <div id="docLines">
                                <table border="1" id="tableDoc">
                                    <thead>
                                        <tr>
                                            <th>Product Code</th>
                                            <th>Product Name</th>
                                            <th>Amount</th>
                                            <th>%VAT</th>
                                            <th>Unit price without VAT</th>
                                            <th>Total price with VAT</th>
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
                                                    <xsl:value-of select="vat"/>
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
                                    <div class="total" id="tot1">Total VAT:
                                        <xsl:value-of select="Totals/vat"/>
                                    </div>
                                    <div class="total" id="tot2">Total without VAT:
                                        <xsl:value-of select="Totals/sum"/>
                                    </div>
                                    <div class="total" id="tot3">
                                        <b>Total:
                                            <xsl:value-of select="Totals/sumVat"/>
                                        </b>
                                    </div>
                                    <p class="date" style="border-top:1px solid black;width:150px;text-align:center">Suplier</p>
                                    <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Customer</p>
                                </div>
                            </div>
                        </body>
                    </html>
                </xsl:template>


                <xsl:template match="/Invoice">
                    <html>
                        <head>
                            <title>Delivery</title>
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
    width:800px;
    margin-left:auto;
    margin-right:auto;
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
                                    <div id="content">
                                        <div id="topDoc">
                                            <h1>Invoice</h1>
                                            <div id="suplier">
                                                Name:
                                                <xsl:value-of select="UserInfo/name"/>
                                                <br />
                                                Street nad No.:
                                                <xsl:value-of select="UserInfo/street"/>
                                                <br />
                                                Zip and city:
                                                <xsl:value-of select="UserInfo/zip"/>
                                                <xsl:value-of select="UserInfo/city"/>
                                                <br />
                                                Country:
                                                <xsl:value-of select="UserInfo/country"/>
                                                <br />
                                                CRN
                                                <xsl:value-of select="UserInfo/ico"/>
                                                <br />
                                                DIC:
                                                <xsl:value-of select="UserInfo/dic"/>
                                                <br />
                                                Banking institution:
                                                <xsl:value-of select="UserInfo/bank"/>
                                                <br />
                                                Account number:
                                                <xsl:value-of select="UserInfo/bankNo"/>
                                                <br />
                                            </div>
                                            <div id="customer">
                                                Name:
                                                <xsl:value-of select="Client/name"/>
                                                <br />
                                                Street nad No.:
                                                <xsl:value-of select="Client/street"/>
                                                <br />
                                                Zip and city:
                                                <xsl:value-of select="Client/zip"/>
                                                <xsl:value-of select="Client/city"/>
                                                <br />
                                                Country:
                                                <xsl:value-of select="Client/country"/>
                                                <br />
                                                CRN
                                                <xsl:value-of select="Client/ico"/>
                                                <br />
                                                DIC:
                                                <xsl:value-of select="Client/dic"/>
                                            </div>

                                            <p class="date">Date of issuance:
                                                <xsl:value-of select="Totals/date"/>
                                            </p>
                                            <p class="docNo">Document No.:
                                                <xsl:value-of select="Totals/docNumber"/>
                                            </p>

                                        </div>
                                        <div id="docLines">
                                            <table border="1" id="tableDoc">
                                                <thead>
                                                    <tr>
                                                        <th>Product Code</th>
                                                        <th>Product Name</th>
                                                        <th>Amount</th>
                                                        <th>%VAT</th>
                                                        <th>Unit price without VAT</th>
                                                        <th>Total price with VAT</th>
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
                                                                <xsl:value-of select="vat"/>
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
                                                <div class="total" id="tot1">Total VAT:
                                                    <xsl:value-of select="Totals/vat"/>
                                                </div>
                                                <div class="total" id="tot2">Total without VAT:
                                                    <xsl:value-of select="Totals/sum"/>
                                                </div>
                                                <div class="total" id="tot3">
                                                    <b>Total:
                                                        <xsl:value-of select="Totals/sumVat"/>
                                                    </b>
                                                </div>
                                                <p class="date" style="border-top:1px solid black;width:150px;text-align:center">Suplier</p>
                                                <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Customer</p>
                                            </div>
                                        </div>
                                    </body>
                                </html>
                            </xsl:template>

                        </xsl:stylesheet>
