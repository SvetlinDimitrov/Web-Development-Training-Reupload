export default function Client(){
    return (
        <section className="client_section layout_padding">
          <div className="container">
            <div className="heading_container heading_center">
              <h2>Testimonial</h2>
            </div>
            <div className="row">
              <div className="col-md-9 mx-auto">
                <div
                  id="customCarousel2"
                  className="carousel slide"
                  data-ride="carousel"
                >
                  <div className="row">
                    <div className="col-md-11">
                      <div className="carousel-inner">
                        <div className="carousel-item active">
                          <div className="box">
                            <div className="client_id">
                              <div className="img-box">
                                <img src="images/client.jpg" alt="" />
                              </div>
                              <h5>Alex Jonson</h5>
                            </div>
                            <div className="detail-box">
                              <p>
                                ipsum dolor sit amet, consectetur adipiscing
                                elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi
                                ut aliquip ex ea commodo consequat. Duis aute
                                irure dolor in reprehenderit in voluptate velit
                              </p>
                            </div>
                          </div>
                        </div>
                        <div className="carousel-item">
                          <div className="box">
                            <div className="client_id">
                              <div className="img-box">
                                <img src="images/client.jpg" alt="" />
                              </div>
                              <h5>Alex Jonson</h5>
                            </div>
                            <div className="detail-box">
                              <p>
                                ipsum dolor sit amet, consectetur adipiscing
                                elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi
                                ut aliquip ex ea commodo consequat. Duis aute
                                irure dolor in reprehenderit in voluptate velit
                              </p>
                            </div>
                          </div>
                        </div>
                        <div className="carousel-item">
                          <div className="box">
                            <div className="client_id">
                              <div className="img-box">
                                <img src="images/client.jpg" alt="" />
                              </div>
                              <h5>Alex Jonson</h5>
                            </div>
                            <div className="detail-box">
                              <p>
                                ipsum dolor sit amet, consectetur adipiscing
                                elit, sed do eiusmod tempor incididunt ut labore
                                et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi
                                ut aliquip ex ea commodo consequat. Duis aute
                                irure dolor in reprehenderit in voluptate velit
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div className="col-md-1">
                      <ol className="carousel-indicators">
                        <li
                          data-target="#customCarousel2"
                          data-slide-to="0"
                          className="active"
                        ></li>
                        <li
                          data-target="#customCarousel2"
                          data-slide-to="1"
                        ></li>
                        <li
                          data-target="#customCarousel2"
                          data-slide-to="2"
                        ></li>
                      </ol>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
    )
}