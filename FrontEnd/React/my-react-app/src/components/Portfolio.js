export default function PortfolioSection(){
    return (
        <section className="portfolio_section ">
          <div className="container">
            <div className="heading_container heading_center">
              <h2>Our Work Portfolio</h2>
            </div>
            <div className="carousel-wrap ">
              <div className="filter_box">
                <nav className="owl-filter-bar">
                  <a href="#" className="item active" data-owl-filter="*">
                    All
                  </a>
                  <a href="#" className="item" data-owl-filter=".decorative">
                    DECORATIVE
                  </a>
                  <a href="#" className="item" data-owl-filter=".facade">
                    FACADES{" "}
                  </a>
                  <a href="#" className="item" data-owl-filter=".perforated">
                    PERFORATED
                  </a>
                  <a href="#" className="item" data-owl-filter=".railing">
                    RAILINGS{" "}
                  </a>
                </nav>
              </div>
            </div>
          </div>
          <div className="owl-carousel portfolio_carousel">
            <div className="item decorative">
              <div className="box">
                <div className="img-box">
                  <img src="images/p1.jpg" alt="" />
                  <div className="btn_overlay">
                    <a href="" className="">
                      See More
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div className="item facade">
              <div className="box">
                <div className="img-box">
                  <img src="images/p2.jpg" alt="" />
                  <div className="btn_overlay">
                    <a href="" className="">
                      See More
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div className="item perforated decorative">
              <div className="box">
                <div className="img-box">
                  <img src="images/p3.jpg" alt="" />
                  <div className="btn_overlay">
                    <a href="" className="">
                      See More
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div className="item railing">
              <div className="box">
                <div className="img-box">
                  <img src="images/p1.jpg" alt="" />
                  <div className="btn_overlay">
                    <a href="" className="">
                      See More
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

    )
}