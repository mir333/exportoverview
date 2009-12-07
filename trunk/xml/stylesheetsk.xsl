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
                <title>Dodací list</title>
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
                                <h1>Dodací list</h1>
                                <div id="suplier">
                                     Mano:
                                    <xsl:value-of select="UserInfo/name"/>
                                    <br />
                                    Adresa:
                                    <xsl:value-of select="UserInfo/street"/>
                                    <br />
                                    Psč a mesto:
                                    <xsl:value-of select="UserInfo/zip"/>,
                                    <xsl:value-of select="UserInfo/city"/>
                                    <br />
                                    Kraina:
                                    <xsl:value-of select="UserInfo/country"/>
                                    <br />
                                    IČO
                                    <xsl:value-of select="UserInfo/ico"/>
                                    <br />
                                    DIČ:
                                    <xsl:value-of select="UserInfo/dic"/>
                                    <br />
                                    Banka:
                                    <xsl:value-of select="UserInfo/bank"/>
                                    <br />
                                    Číslo účtu:
                                    <xsl:value-of select="UserInfo/bankNo"/>
                                    <br />
                                </div>
                                <div id="customer">
                                    Mano:
                                    <xsl:value-of select="Client/name"/>
                                    <br />
                                    Adresa:
                                    <xsl:value-of select="Client/street"/>
                                    <br />
                                    Psč a mesto:
                                    <xsl:value-of select="Client/zip"/>
                                    <xsl:value-of select="Client/city"/>
                                    <br />
                                   Kraina:
                                    <xsl:value-of select="Client/country"/>
                                    <br />
                                    IČO
                                    <xsl:value-of select="Client/ico"/>
                                    <br />
                                    DIČ:
                                    <xsl:value-of select="Client/dic"/>
                                </div>

                                <p class="date">Dátum vystavenia:
                                    <xsl:value-of select="Totals/date"/>
                                </p>
                            <p class="docNo">Číslo dokumentu:
                                    <xsl:value-of select="Totals/docNumber"/>
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
                                        <b>Spolu:
                                            <xsl:value-of select="Totals/sumVat"/>
                                        </b>
                                    </div>
                                    <p class="date" style="border-top:1px solid black;width:150px;text-align:center">Dodávateľ</p>
                                    <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Príjemca</p>
                                </div>
                            </div>
                        </body>
                    </html>
                </xsl:template>


                <xsl:template match="/Invoice">
                     <html>
            <head>
                <title>Faktúra</title>
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
                                <h1>Faktúra</h1>
                                <div id="suplier">
                                     Mano:
                                    <xsl:value-of select="UserInfo/name"/>
                                    <br />
                                    Adresa:
                                    <xsl:value-of select="UserInfo/street"/>
                                    <br />
                                    Psč a mesto:
                                    <xsl:value-of select="UserInfo/zip"/>,
                                    <xsl:value-of select="UserInfo/city"/>
                                    <br />
                                    Kraina:
                                    <xsl:value-of select="UserInfo/country"/>
                                    <br />
                                    IČO
                                    <xsl:value-of select="UserInfo/ico"/>
                                    <br />
                                    DIČ:
                                    <xsl:value-of select="UserInfo/dic"/>
                                    <br />
                                    Banka:
                                    <xsl:value-of select="UserInfo/bank"/>
                                    <br />
                                    Číslo účtu:
                                    <xsl:value-of select="UserInfo/bankNo"/>
                                    <br />
                                </div>
                                <div id="customer">
                                    Mano:
                                    <xsl:value-of select="Client/name"/>
                                    <br />
                                    Adresa:
                                    <xsl:value-of select="Client/street"/>
                                    <br />
                                    Psč a mesto:
                                    <xsl:value-of select="Client/zip"/>
                                    <xsl:value-of select="Client/city"/>
                                    <br />
                                   Kraina:
                                    <xsl:value-of select="Client/country"/>
                                    <br />
                                    IČO
                                    <xsl:value-of select="Client/ico"/>
                                    <br />
                                    DIČ:
                                    <xsl:value-of select="Client/dic"/>
                                </div>

                                <p class="date">Dátum vystavenia:
                                    <xsl:value-of select="Totals/date"/>
                                </p>
                            <p class="docNo">Číslo dokumentu:
                                    <xsl:value-of select="Totals/docNumber"/>
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
                                        <b>Spolu:
                                            <xsl:value-of select="Totals/sumVat"/>
                                        </b>
                                    </div>
                                    <p class="date" style="border-top:1px solid black;width:150px;text-align:center">Dodávateľ</p>
                                    <p class="docNo" style="border-top:1px solid black;width:150px;text-align:center">Príjemca</p>
                                </div>
                            </div>
                        </body>
                    </html>
                            </xsl:template>

                        </xsl:stylesheet>
