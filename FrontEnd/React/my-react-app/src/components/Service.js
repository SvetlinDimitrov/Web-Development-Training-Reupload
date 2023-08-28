export default function ServiceSection(){
    return (
        <section className="service_section layout_padding">
          <div className="container ">
            <div className="heading_container heading_center">
              <h2>
                Our <span>Services</span>
              </h2>
            </div>
            <div className="row">
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s1.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Home Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s2.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Gate Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s3.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Window Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s4.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Machine Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s5.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Bike Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
              <div className="col-sm-6 col-md-4">
                <div className="box ">
                  <div className="img-box">
                    <img src="images/s6.png" alt="" />
                  </div>
                  <div className="detail-box">
                    <h5>Car Welding</h5>
                    <p>
                      when looking at its layout. The point of using Lorem Ipsum
                      is that it has a more-or-less normal
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div className="btn-box">
              <a href="">Read More</a>
            </div>
          </div>
          <Contact/>
        </section>
        
    );
}

export function Contact (){
    return (
         <section className="contact_section ">
         <div className="container">
           <div className="heading_container heading_center">
             <h2>
               Get In <span>Touch</span>
             </h2>
           </div>
           <div className="row">
             <div className="col-md-6 px-0">
               <div className="form_container">
                 <form action="">
                   <div className="form-row">
                     <div className="form-group col">
                       <input
                         type="text"
                         className="form-control"
                         placeholder="Your Name"
                       />
                     </div>
                   </div>
                   <div className="form-row">
                     <div className="form-group col-lg-6">
                       <input
                         type="text"
                         className="form-control"
                         placeholder="Phone Number"
                       />
                     </div>
                     <div className="form-group col-lg-6">
                       <select name="" id="" className="form-control wide">
                         <option value="">Select Service</option>
                         <option value="">Service 1</option>
                         <option value="">Service 2</option>
                         <option value="">Service 3</option>
                       </select>
                     </div>
                   </div>
                   <div className="form-row">
                     <div className="form-group col">
                       <input
                         type="email"
                         className="form-control"
                         placeholder="Email"
                       />
                     </div>
                   </div>
                   <div className="form-row">
                     <div className="form-group col">
                       <input
                         type="text"
                         className="message-box form-control"
                         placeholder="Message"
                       />
                     </div>
                   </div>
                   <div className="btn_box">
                     <button>SEND</button>
                   </div>
                 </form>
               </div>
             </div>
             <div className="col-md-6 px-0">
               <div className="map_container">
                 <div className="map">
                   <div id="googleMap"></div>
                 </div>
               </div>
             </div>
           </div>
         </div>
       </section>
    )
}