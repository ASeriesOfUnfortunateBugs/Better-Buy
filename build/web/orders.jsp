<%@page import="Business.*"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Better Buy | Orders</title>
      <meta name="keywords" content="Better Buy, electronics, retail, pc, game consoles, home theater">
      <meta name="description" content="Better Buy is your one stop shop for all your electronics needs.">
      <meta name="author" content="Rachel Heaton">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
   <body class="main-layout inner_posituong">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="images/loading.gif" alt="#" /></div>
      </div>
      <!-- end loader -->
      <!-- header -->
      <header class="fixed-top">
         <!-- header inner -->
         <div class="header">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                     <div class="full">
                        <div>
                           <div class="logo">
                              <a href="index.html"><img src="images/logo.svg" alt="Better Buy Logo" height="150px" width="150px" /></a>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                     <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                        <div>
                           <ul class="navbar-nav mr-auto">
                              <li class="nav-item">
                                 <a class="nav-link" href="admin.html">Return to admin home</a>
                              </li>
                           </ul>
                        </div>
                     </nav>
                  </div>
               </div>
            </div>
         </div>
      </header>      
      <!-- end header -->

      <!-- orders -->
      <div  class="orders">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2>Orders</h2>
                  </div>
               </div>
            </div>  
         </div>

         <!-- descriptive text -->
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <p class="text-center">Use the table below to view customer orders and update order status.</p><br />
               </div>
            </div>
         </div>

         <!-- order table -->
         <div class="container">
            <div class="row">
               <div class="col-md-8">
                  <table class="table table-bordered table-striped">
                     <thead class="thead-dark">
                        <th>Order No.</th>
                        <th>Customer ID</th>
                        <th>Product No.</th>
                        <th>Quantity</th>
                        <th>Status</th>
                     </thead>
                     <tbody>
                        <%  Order orders = new Order();
                            orders.getOrders();
                            
                            int count = orders.olist.count;
                            for (int i = 0; i < count; i++) {
                        %>
                        <tr>
                            <td><%= orders.olist.oArry[i].getOrderNo() %></td>
                            <td><%= orders.olist.oArry[i].getCustID() %></td>
                            <td><%= orders.olist.oArry[i].getProductNo() %></td>
                            <td><%= orders.olist.oArry[i].getQuantity() %></td>
                            <td><%= orders.olist.oArry[i].getStatus() %></td>
                        </tr>
                        <% } %>
                     </tbody>
                  </table>
               </div>

               <!-- form for updating order status -->
               <div class="col-md-4">
                  <form action="#" method="post" id="orderMng">
                     <div class="form-group">
                        <label for="orderno">Order No.:</label>
                        <input class="form-control" type="text" form="orderMng" name="#" id="orderno" />
                     </div>
                     <div class="form-group">
                        <label for="orderstatus">Status</label>
                        <select class="form-control" name="#" id="orderstatus">
                           <option>Open</option>
                           <option>Ready</option>
                           <option>Shipped</option>
                           <option>Picked up</option>
                        </select>
                     </div>

                     <input class="btn btn-default btn-block" type="submit" form="orderMng" value="Update" />
                  </form>
               </div>
            </div>
         </div>

      </div>
      <!-- end products -->
      <!--  footer -->
      <footer>
         <div class="footer">
            <div class="container">
               
                  <div class="">
                     <img class="logo1" src="images/logo.svg" alt="Better Buy logo" height="150px" width="150px" />
                     <ul class="social_icon">
                        <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin-square" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                     </ul>
                  </div>
                  
               
            </div>
            <div class="copyright">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
                        <p>© 2022 All Rights Reserved. Designed by Chattahoochee Technical College</a></p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- end footer -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
   </body>
</html>

