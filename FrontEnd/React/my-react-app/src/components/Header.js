export default function HeroSection(){
    return (
        <div className="hero_area">
        <Header/>
        <SliderSection/>
        </div>
    )
}

export  function Header(){
    return (
        <header className="header_section">
            <div className="header_top">
              <div className="container-fluid header_top_container">
                <a className="navbar-brand " href="index.html">
                  {" "}
                  Tro<span>Weld</span>{" "}
                </a>
                <div className="contact_nav">
                  <a href="">
                    <i className="fa fa-map-marker" aria-hidden="true"></i>
                    <span>Location</span>
                  </a>
                  <a href="">
                    <i className="fa fa-phone" aria-hidden="true"></i>
                    <span>Call : +01 123455678990</span>
                  </a>
                  <a href="">
                    <i className="fa fa-envelope" aria-hidden="true"></i>
                    <span>demo@gmail.com</span>
                  </a>
                </div>
                <div className="social_box">
                  <a href="">
                    <i className="fa fa-facebook" aria-hidden="true"></i>
                  </a>
                  <a href="">
                    <i className="fa fa-twitter" aria-hidden="true"></i>
                  </a>
                  <a href="">
                    <i className="fa fa-linkedin" aria-hidden="true"></i>
                  </a>
                  <a href="">
                    <i className="fa fa-instagram" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
            </div>
            <div className="header_bottom">
              <div className="container-fluid">
                <nav className="navbar navbar-expand-lg custom_nav-container ">
                  <a className="navbar-brand navbar_brand_mobile" href="index.html">
                    {" "}
                    Tro<span>Weld</span>{" "}
                  </a>

                  <button
                    className="navbar-toggler"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                  >
                    <span className=""> </span>
                  </button>

                  <div
                    className="collapse navbar-collapse"
                    id="navbarSupportedContent"
                  >
                    <ul className="navbar-nav  ">
                      <li className="nav-item active">
                        <a className="nav-link" href="index.html">
                          Home <span className="sr-only">(current)</span>
                        </a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="service.html">
                          Services
                        </a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="about.html">
                          {" "}
                          About
                        </a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="portfolio.html">
                          Portfolio
                        </a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="contact.html">
                          Contact Us
                        </a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="#">
                          <i className="fa fa-user" aria-hidden="true"></i>
                          <span>Login</span>
                        </a>
                      </li>
                      <form className="form-inline">
                        <button
                          className="btn  my-2 my-sm-0 nav_search-btn"
                          type="submit"
                        >
                          <i className="fa fa-search" aria-hidden="true"></i>
                        </button>
                      </form>
                    </ul>
                  </div>
                </nav>
              </div>
            </div>
          </header>
    )
}

export  function SliderSection(){
    return (
        <section className="slider_section ">
            <div
              id="customCarousel1"
              className="carousel slide"
              data-ride="carousel"
            >
              <div className="carousel-inner">
                <div className="carousel-item active">
                  <div className="container ">
                    <div className="detail-box">
                      <h1>
                        We Build <br />
                        The Things Architects <br />
                        Dream Up
                      </h1>
                      <div className="btn-box">
                        <a href="" className="btn1">
                          Read More
                        </a>
                        <a href="" className="btn2">
                          Contact Us
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="carousel-item">
                  <div className="container ">
                    <div className="detail-box">
                      <h1>
                        We Build <br />
                        The Things Architects <br />
                        Dream Up
                      </h1>
                      <div className="btn-box">
                        <a href="" className="btn1">
                          Read More
                        </a>
                        <a href="" className="btn2">
                          Contact Us
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="carousel-item">
                  <div className="container ">
                    <div className="detail-box">
                      <h1>
                        We Build <br />
                        The Things Architects <br />
                        Dream Up
                      </h1>
                      <div className="btn-box">
                        <a href="" className="btn1">
                          Read More
                        </a>
                        <a href="" className="btn2">
                          Contact Us
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="carousel_btn-box">
                <a
                  className="carousel-control-prev"
                  href="#customCarousel1"
                  role="button"
                  data-slide="prev"
                >
                  <i className="fa fa-arrow-left" aria-hidden="true"></i>
                  <span className="sr-only">Previous</span>
                </a>
                <a
                  className="carousel-control-next"
                  href="#customCarousel1"
                  role="button"
                  data-slide="next"
                >
                  <i className="fa fa-arrow-right" aria-hidden="true"></i>
                  <span className="sr-only">Next</span>
                </a>
              </div>
            </div>
          </section>
    )
}