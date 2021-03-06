<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello World</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/general.css">
    <link rel="stylesheet" type="text/css" href="css/homepage.css">
    <link rel="stylesheet" type="text/css" href="css/parties.css">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<s:url action="home"/>">CreditMut</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<s:url action="home"/>">Home <span class="sr-only">(current)</span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Party <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<s:url action="index-party"/>">View custom parties</a></li>
                            <li><a href="<s:url action="my-parties"/>">View my parties</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<s:url action="create-party"/>">Create a new party</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Tournament <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<s:url action="index-tournament"/>">View all tournaments</a></li>
                            <li><a href="<s:url action="my-tournaments"/>">View my tournaments</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<s:url action="create-tournament"/>">Create a new tournament</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Group <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<s:url action="index-group"/>">View public groups</a></li>
                            <li><a href="<s:url action="my-groups"/>">View my groups</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<s:url action="create-group"/>">Create a new group</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <% if (session.getAttribute("user_session") == null) { %>
                        <li><a href="#" data-toggle="modal" data-target="#signInModal">Sign in</a></li>
                        <li>
                            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#signUpModal">
                                Sign up
                            </button>
                        </li>
                    <% } else { %>
                        <li><a href="<s:url action="sign-out"/>">Logout</a></li>
                    <% } %>
                    <!--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>-->
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </div>
</nav>

<div class="first-element"></div>