<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 10/07/2022
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UAhelper</title>

    <!-- Custom fonts for this template-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat&family=Oswald:wght@700" rel="stylesheet">

    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="<c:url value="/theme/vendor/jquery/jquery.min.js"/>">
    <link href="<c:url value="/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"/>">
    <link href="<c:url value="/theme/vendor/jquery-easing/jquery.easing.min.js"/>">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">
</head>


<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index">
            <div class="sidebar-brand-text">
                <p class="h-font">UA<span class="r-font">helper</span></p>
            </div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <a href="/index/" class="btn btn-primary ua-btn">
                    <span class="icon text-white-50">
                    </span>
            <span class="text">O projekcie</span>
        </a>
        <a href="/show/${user.id} class=" btn btn-primary ua-btn">
        <span class="icon text-white-50">
                    </span>
        <span class="text">Moje dane</span>
        </a>
        <a href="/user/needs/show" class="btn btn-primary ua-btn">
                    <span class="icon text-white-50">
                    </span>
            <span class="text">Zarządzanie potrzebami</span>
        </a>
        </a>
        <a href="/user/delete" class="btn btn-primary ua-btn">
                    <span class="icon text-white-50">
                    </span>
            <span class="text">Usuń konto</span>
        </a>


        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">

            <%--            <button class="rounded-circle border-0" id="sidebarToggle"></button>--%>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <div class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">

            </div>
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>
                <ul class="navbar-nav ml-auto">
                    <a href="/user/show" class="btn btn-primary ua-btn-head">
                    <span class="icon text-white-50">
                    </span>
                        <span class="text">Witaj, ${user.name}</span>
                    </a>
                    <a href="/logout" class="btn btn-primary ua-btn-head">
                    <span class="icon text-white-50">
                    </span>
                        <span class="text">Wyloguj</span>
                    </a>
                </ul>
                </ul>

            </nav>
