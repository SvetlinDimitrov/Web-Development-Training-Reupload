export default function Info(){
    return (
        
        <section className="info_section ">
          <div className="info_container layout_padding2">
            <div className="container">
              <div className="info_logo">
                <a className="navbar-brand" href="index.html">
                  {" "}
                  Tro<span>Weld</span>{" "}
                </a>
              </div>
              <div className="info_main">
                <div className="row">
                  <div className="col-md-3 col-lg-2">
                    <div className="info_link-box">
                      <h5>Useful Link</h5>
                      <ul>
                        <li className=" active">
                          <a className="" href="index.html">
                            Home <span className="sr-only">(current)</span>
                          </a>
                        </li>
                        <li className="">
                          <a className="" href="about.html">
                            About{" "}
                          </a>
                        </li>
                        <li className="">
                          <a className="" href="service.html">
                            Services{" "}
                          </a>
                        </li>
                        <li className="">
                          <a className="" href="portfolio.html">
                            {" "}
                            Portfolio{" "}
                          </a>
                        </li>
                        <li className="">
                          <a className="" href="contact.html">
                            {" "}
                            Contact{" "}
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                  <div className="col-md-3 ">
                    <h5>Welding</h5>
                    <p>
                      Lorem ipsum dolor sit amet, consectetur
                      adipiscinaliquaLoreadipiscing
                    </p>
                  </div>
                  <div className="col-md-3 mx-auto  ">
                    <h5>social media</h5>
                    <div className="social_box">
                      <a href="#">
                        <i className="fa fa-facebook" aria-hidden="true"></i>
                      </a>
                      <a href="#">
                        <i className="fa fa-twitter" aria-hidden="true"></i>
                      </a>
                      <a href="#">
                        <i className="fa fa-linkedin" aria-hidden="true"></i>
                      </a>
                      <a href="#">
                        <i className="fa fa-youtube-play" aria-hidden="true"></i>
                      </a>
                    </div>
                  </div>
                  <div className="col-md-3">
                    <h5>Our welding center</h5>
                    <p>
                      Lorem ipsum dolor sit amet, consectetur
                      adipiscinaliquaLoreadipiscing
                    </p>
                  </div>
                </div>
              </div>
              <div className="info_bottom">
                <div className="row">
                  <div className="col-lg-9">
                    <div className="info_contact ">
                      <div className="row">
                        <div className="col-md-3">
                          <a href="#" className="link-box">
                            <i className="fa fa-map-marker" aria-hidden="true"></i>
                            <span>Location</span>
                          </a>
                        </div>
                        <div className="col-md-5">
                          <a href="#" className="link-box">
                            <i className="fa fa-phone" aria-hidden="true"></i>
                            <span>Call +01 1234567890</span>
                          </a>
                        </div>
                        <div className="col-md-4">
                          <a href="#" className="link-box">
                            <i className="fa fa-envelope" aria-hidden="true"></i>
                            <span>demo@gmail.com</span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-3">
                    <div className="info_form ">
                      <form action="">
                        <input type="email" placeholder="Enter Your Email" />
                        <button>
                          <i className="fa fa-arrow-right" aria-hidden="true"></i>
                        </button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
    )
}