

<nav id="tmSidebar" class="tm-bg-black-transparent tm-sidebar">
            <button class="navbar-toggler" type="button" aria-label="Toggle navigation">
              <i class="fas fa-bars"></i>
            </button>
            <div class="tm-sidebar-sticky">
              <div class="tm-brand-box">
                <div class="tm-double-border-1">
                  <div class="tm-double-border-2">
                    <h1 class="tm-brand text-uppercase">Hello <%=userName%></h1>
                  </div>
                </div>
              </div>

              <ul id="tmMainNav" class="nav flex-column text-uppercase text-right tm-main-nav">
                <li class="nav-item">
                    <a href="<%=path%>/users/home.jsp" class="nav-link" align="center">Home
                    <span class="d-inline-block mr-3"></span>
                    <span class="d-inline-block tm-white-rect"></span>
                    
                  </a>
                </li>
                <li class="nav-item">
                    <a href="<%=path%>/users/addgroup.jsp" class="nav-link" align="center">Add Blood Group
                    <span class="d-inline-block mr-3"></span>
                    <span class="d-inline-block tm-white-rect"></span>
                    
                  </a>
                </li>
                <li class="nav-item">
                    <a href="<%=path%>/users/searchgroup.jsp" class="nav-link" align="center">Search Group
                    <span class="d-inline-block mr-3"></span>
                    <span class="d-inline-block tm-white-rect"></span>
                  </a>
                </li>
                <li class="nav-item">
                    <a href="<%=path%>/logout" class="nav-link" align="center">Logout
                        <span class="d-inline-block mr-3"></span>
                        <span class="d-inline-block tm-white-rect"></span>
                    </a>
                </li>
<!--                <li class="nav-item">
                  <a href="#clients" class="nav-link">
                    <span class="d-inline-block mr-3">Logout</span>
                    <span class="d-inline-block tm-white-rect"></span>
                  </a>
                </li>-->
<!--                <li class="nav-item">
                  <a href="#talk" class="nav-link">
                    <span class="d-inline-block mr-3">Let's Talk</span>
                    <span class="d-inline-block tm-white-rect"></span>
                  </a>
                </li>-->
              </ul>
              <ul class="nav flex-row tm-social-links">
                <li class="nav-item">
                  <a href="https://facebook.com" class="nav-link tm-social-link">
                    <i class="fab fa-facebook-f"></i>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="https://twitter.com" class="nav-link tm-social-link">
                    <i class="fab fa-twitter"></i>
                  </a>
                </li>
<!--                <li class="nav-item">
                  <a href="https://dribbble.com" class="nav-link tm-social-link">
                    <i class="fab fa-dribbble"></i>
                  </a>
                </li>-->
                <li class="nav-item">
                  <a href="https://linkedin.com" class="nav-link tm-social-link">
                    <i class="fab fa-linkedin-in"></i>
                  </a>
                </li>
              </ul>
              <footer class="text-center text-white small">
                <p class="mb--0 mb-2">Copyright 2021 Blood Bank</p>
               
              </footer>
            </div>
          </nav>