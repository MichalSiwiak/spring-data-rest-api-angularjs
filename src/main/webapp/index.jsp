<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>coffeecoding.net</title>
    <meta name="description"
          content="Free open source projects present different java solutions using spring, hibernate and other popular frameworks.">
    <meta name="keywords"
          content="java, spring, hibernate, apache, tomcat, coding, programmer, linux, google cloud platform, open source, bootstrap, mysql, java ideas">
    <!-- CSS dependencies -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.standalone.min.css">
    <link rel="stylesheet" href="https://coffeecoding.net/resources/css/now-ui-kit.css" type="text/css">
    <link rel="stylesheet" href="https://coffeecoding.net/resources/css/style.css" type="text/css">
    <link rel="icon" href="resources/img/favicon.png">
    <!-- PAGE scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
</head>


<body class="bg-light text-dark">
<div id="wrap">
    <div id="main" class="clear-top">


        <div class="collapse" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 py-4">
                        <h4>About</h4>
                        <p class="text-info">Free open source projects present different java solutions using spring,
                            hibernate
                            and other popular frameworks.</p>
                    </div>
                    <div class="col-md-3 offset-md-1 py-4">
                        <h4>Contact</h4>
                        <ul class="list-unstyled">
                            <li>
                                <a href="https://pl.linkedin.com/in/michalsiwiak" class="text-secondary"
                                   target="_blank">Follow
                                    on LinkedIn</a>
                            </li>
                            <li>
                                <a href="mailto:info@coffeecoding.net" target="_top" class="text-secondary">Email me</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="navbar sticky-top navbar-dark bg-info">
            <div class="container d-flex justify-content-between">
                <a href="https://www.coffeecoding.net/" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-home fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">
                    HOME
                </text>
                </a>
                <a href="https://github.com/MichalSiwiak/spring-data-rest-api-angularjs" target="_blank"
                   class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-git-square fa-fw d-inline-block lead fa-2x"></i>&nbsp;&nbsp;<text class="">SOURCE
                    CODE
                </text>
                </a>
                <a href="${pageContext.request.contextPath}/demo" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-desktop fa-2x fa-fw lead d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">DEMO VIEW
                </text>
                </a>

                <a href="https://coffeecoding.net/resources/img/cv_msiwiak.pdf" target="_blank"
                   class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-address-card fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">RESUME
                </text>
                </a>
                <a href="/contact" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-envelope fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">CONTACT
                </text>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"><span
                        class="navbar-toggler-icon"></span></button>
            </div>
        </div>


        <div class="py-5">
            <div class="container">
                <h1 class="text-left">CRM System - Spring Data Rest Api</h1>
                <hr>
                <h5>This application is implementation of database functionality using spring data. The
                    application sends sql queries (including CRUD methods) and receives data in JSON format. On
                    the client side, the web application supports received JSON data using AngularJS. The database is
                    refreshed once a day at night with sample data.<br></h5>
                <h5>The application supports operations:</h5>
                <h5>
                    <ul>
                        <li>creating records,</li>
                        <li>reading records,</li>
                        <li>editing records,</li>
                        <li>deleting records,</li>
                        <li>filtering records by price range, country and item type.</li>
                    </ul>
                </h5>
                <h5><b>Back End: </b>Java, Spring MVC, Spring Data, Hibernate, MySQL.</h5>
                <h5><b>Front End: </b>AngularJS, HTML, CSS.</h5>
                <h5>To run application: git clone
                    https://github.com/MichalSiwiak/spring-data-rest-api-angularjs.git,
                    upload and run application using tomcat application server or similar.</h5>
                <h5>Demo View: <a href="https://www.coffeecoding.net/crm/demo">https://www.coffeecoding.net/crm/demo</a>
                </h5>
                <h5 class="mb-3">SalesDAO implementation class:</h5>
                <pre><code class="java">
package net.coffeecoding.dao;

import net.coffeecoding.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveSales(Sales sales) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(sales);
        return sales.getId();
    }

    @Override
    public List<Sales> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("SELECT c from Sales c",
                        Sales.class);
        List<Sales> salesList = query.getResultList();

        return salesList;
    }

    @Override
    public void deleteSales(Sales sales) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(sales);
    }

    @Override
    public List<String> findDistinctByItemType() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<String> query =
                currentSession.createQuery("select DISTINCT(s.itemType) from Sales s",
                        String.class);
        List<String> itemsType = query.getResultList();
        return itemsType;
    }

    @Override
    public List<Sales> findByItemTypeEquals(String itemType) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where s.itemType = :itemType ",
                        Sales.class);
        query.setParameter("itemType", itemType);
        List<Sales> salesList = query.getResultList();

        return salesList;
    }

    @Override
    public List<Sales> findByCountryNameLike(String country) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where lower(s.country) like lower(concat('%', :country,'%'))",
                        Sales.class);
        query.setParameter("country", country);
        List<Sales> salesList = query.getResultList();
        return salesList;

    }

    @Override
    public List<Sales> findByUnitsPriceLessThan(double unitsPrice) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Sales> query =
                currentSession.createQuery("select s from Sales s where s.unitsPrice < :unitsPrice ",
                        Sales.class);
        query.setParameter("unitsPrice", unitsPrice);
        List<Sales> salesList = query.getResultList();
        return salesList;
    }
}
                </code></pre>
                <h5 class="mb-3">Sales service implementation class:</h5>
                <pre><code class="java">
package net.coffeecoding.service;

import net.coffeecoding.dao.SalesDAO;
import net.coffeecoding.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesDAO salesDAO;

    @Transactional
    @Override
    public int saveSales(Sales sales) {
        salesDAO.saveSales(sales);
        return sales.getId();

    }

    @Transactional
    @Override
    public List<Sales> findAll() {
        return salesDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteSales(Sales sales) {
        salesDAO.deleteSales(sales);
    }

    @Override
    @Transactional
    public List<String> findDistinctByItemType() {
        return salesDAO.findDistinctByItemType();
    }

    @Override
    @Transactional
    public List<Sales> findByItemTypeEquals(String itemType) {
        return salesDAO.findByItemTypeEquals(itemType);
    }

    @Override
    @Transactional
    public List<Sales> findByCountryNameLike(String country) {
        return salesDAO.findByCountryNameLike(country);
    }

    @Override
    @Transactional
    public List<Sales> findByUnitsPriceLessThan(double unitsPrice) {
        return salesDAO.findByUnitsPriceLessThan(unitsPrice);
    }
}
                </code></pre>
                <h5 class="mb-3">Sales Controller class:</h5>
                <pre><code class="java">
package net.coffeecoding.controller;

import net.coffeecoding.entity.Sales;
import net.coffeecoding.service.SalesService;
import net.coffeecoding.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;
    @Autowired
    Utils utils;
    @Autowired
    private ServletContext servletContext;

    private SalesList salesListTotal;
    private SalesList salesListByItemTypeEquals;
    private SalesList salesListByCountryNameLike;
    private SalesList salesListByUnitsPriceLessThan;


    @PostConstruct
    private void init() {

        salesListByItemTypeEquals = new SalesList();
        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike = new SalesList();
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan = new SalesList();
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());
    }

    @GetMapping("/demo")
    public String getDemo() {
        return "crm-form";
    }


    @RequestMapping(value = "/countryName", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByCountryNameLike(@RequestBody String countryName) {

        if (countryName.equals("all")) {
            salesListByCountryNameLike.setSalesList(salesService.findAll());
        } else {
            salesListByCountryNameLike.setSalesList(salesService.findByCountryNameLike(countryName));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/itemTypes", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> findDistinctByItemType() {
        List<String> itemTypes = salesService.findDistinctByItemType();
        return new ResponseEntity<>(itemTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "/itemType", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByItemTypeEquals(@RequestBody String itemType) {
        if (itemType.equals("ALL")) {
            salesListByItemTypeEquals.setSalesList(salesService.findAll());
        } else {
            salesListByItemTypeEquals.setSalesList(salesService.findByItemTypeEquals(itemType));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/price", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByUnitsPriceLessThan(@RequestBody String price) {
        salesListByUnitsPriceLessThan
                .setSalesList(salesService
                        .findByUnitsPriceLessThan(Double.parseDouble(price)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> refresh() {

        List<Sales> salesListCsv = utils.readCsvData(servletContext.getRealPath("/WEB-INF/data/sample.csv"));

        for (Sales sales : salesService.findAll()) {
            salesService.deleteSales(sales);
        }
        for (Sales sales : salesListCsv) {
            salesService.saveSales(sales);
        }
        init();
        return new ResponseEntity<>("Successfully refreshed database! Number of records: " + salesListCsv.size(), HttpStatus.OK);
    }

    /**
     * HTTP GET - Get all countries
     */
    @RequestMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<SalesList> findAll() {

        salesListTotal = new SalesList();
        salesListTotal.setSalesList(salesService.findAll());

        List<Sales> common = new ArrayList<>();

        try {
            common = salesListTotal.getSalesList()
                    .stream()
                    .filter(salesListByItemTypeEquals.getSalesList()::contains)
                    .filter(salesListByCountryNameLike.getSalesList()::contains)
                    .filter(salesListByUnitsPriceLessThan.getSalesList()::contains)
                    .collect(toList());

        } catch (Exception e) {
        }

        salesListTotal.setSalesList(common);
        HttpHeaders headers = new HttpHeaders();
        headers.add("rowsNumberMessage", "Number of rows returned: " + common.size() + ".");
        return new ResponseEntity<>(salesListTotal, headers, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new sales
     */
    @RequestMapping(value = "/sales", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createSales(@RequestBody Sales newSales) {
        newSales.setId(0);
        int id = salesService.saveSales(newSales);

        salesListByItemTypeEquals.setSalesList(salesService.findAll());
        salesListByCountryNameLike.setSalesList(salesService.findAll());
        salesListByUnitsPriceLessThan.setSalesList(salesService.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Successfully added new row with id = " + id + ".");

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update sales
     */
    @RequestMapping(value = "/sales/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Sales> updateSales(@PathVariable("id") int id, @RequestBody Sales sales) {

        Sales salesToUpdate = new Sales();
        try {
            salesToUpdate = getSalesById(id);
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }

        if (salesToUpdate != null) {

            //salesToUpdate.setRegion(sales.getRegion());
            salesToUpdate.setCountry(sales.getCountry());
            salesToUpdate.setItemType(sales.getItemType());
            //salesToUpdate.setSalesChannel(sales.getSalesChannel());
            salesToUpdate.setOrderPriority(sales.getOrderPriority());
            //salesToUpdate.setOrderDate(sales.getOrderDate());
            //salesToUpdate.setOrderId(sales.getOrderId());
            //salesToUpdate.setShipDate(sales.getShipDate());
            salesToUpdate.setUnitsSold(sales.getUnitsSold());
            salesToUpdate.setUnitsPrice(sales.getUnitsPrice());
            //salesToUpdate.setUnitsCost(sales.getUnitsCost());
            //salesToUpdate.setTotalRevenue(sales.getTotalRevenue());
            salesToUpdate.setTotalCost(sales.getTotalCost());
            //salesToUpdate.setTotalProfit(sales.getTotalProfit());

            salesService.saveSales(salesToUpdate);

            HttpHeaders headers = new HttpHeaders();
            headers.add("message", "Successfully updated row with id = " + id + ".");
            return new ResponseEntity<>(salesToUpdate, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * HTTP DELETE - Delete sales
     */
    @RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSales(@PathVariable("id") int id) {

        Sales salesToDelete;
        try {
            salesToDelete = getSalesById(id);
            if (salesToDelete != null) {
                salesService.deleteSales(salesToDelete);
                HttpHeaders headers = new HttpHeaders();
                headers.add("message", "Successfully deleted row with id = " + id + ".");
                return new ResponseEntity<>(headers, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Sales getSalesById(int id) {
        for (Sales sales : salesListTotal.getSalesList()) {
            if (sales.getId() == id) {
                return sales;
            }
        }
        return null;
    }

}
                </code></pre>
                <h5 class="mb-3">SalesList class:</h5>
                <pre><code class="java">
package net.coffeecoding.controller;

import net.coffeecoding.entity.Sales;

import java.util.List;

public class SalesList {

    private List<Sales> salesList;

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @Override
    public String toString() {
        return "SalesList{" +
                "salesList=" + salesList +
                '}';
    }
}
                </code></pre>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.11.0/highlight.min.js"></script>
                <script>
                    hljs.initHighlightingOnLoad();
                </script>
            </div>
        </div>


    </div>
</div>


<footer class="footer bg-dark text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>© Copyright 2018 coffeecoding.net - All rights reserved.<br>Contact: info@coffeecoding.net<br>Warsaw PL<br><a
                href="https://www.coffeecoding.net/">Visit the homepage</a>
        </p>
    </div>
</footer>


</body>
</html>