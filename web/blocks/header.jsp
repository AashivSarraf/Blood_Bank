
<%@page import="com.bloodbank.dto.User"%>
<%
    String path=application.getContextPath();
    User user=null;
    String userName="";
    String email="";
    Object obj=session.getAttribute("user");
    if(obj!=null){
        user=(User)obj;
        userName=user.getUserName();
        email=user.getEmail();
    }
    
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />

    <title>Blood Bank</title>
<!--
DREAM PULSE
https://templatemo.com/tm-536-dream-pulse
-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" />
    <link rel="stylesheet" href="<%=path%>/assets/css/all.min.css" />
    <link rel="stylesheet" href="<%=path%>/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=path%>/assets/slick/slick.css"/>    
    <link rel="stylesheet" href="<%=path%>/assets/slick/slick-theme.css"/>    
    <link rel="stylesheet" href="<%=path%>/assets/css/magnific-popup.css">
    <link rel="stylesheet" href="<%=path%>/assets/css/templatemo-dream-pulse.css" />
  </head>
  <body>
    <main class="container-fluid">
      <div class="row">