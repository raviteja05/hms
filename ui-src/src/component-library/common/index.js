import React from "react";

export const pageData = window.data;
export const Header = () => {
  return (
    <nav
      className="navbar navbar-light navbar-expand-lg bg-white clean-navbar"
      style={{ "background-color": "rgba(255,255,255,0)" }}
    >
      <div className="container">
        <a
          className="navbar-brand logo"
          href="#"
          style={{ "font-family": "ABeeZee, sans-serif" }}
        >
          AppCal
        </a>
        <button
          data-toggle="collapse"
          className="navbar-toggler"
          data-target="#navcol-1"
        >
          <span className="sr-only">Toggle navigation</span>
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navcol-1">
          <ul className="nav navbar-nav ml-auto">
            {pageData.navigation.navigationLinks.map((el) => (
              <li className="nav-item" role="presentation">
                <a className="nav-link active" href={el.url}>
                  {el.name}
                </a>
              </li>
            ))}
             {pageData.auth.role==="DOCTOR"&&<li className="nav-item" role="presentation">
                <a className="nav-link active" href="/doc/doctor-dashboard">
                  Dashboard
                </a>
              </li>}
              {pageData.auth.role==="CUSTOMER"&&<li className="nav-item" role="presentation">
                <a className="nav-link active" href="/app/patient-dashboard">
                  Dashboard
                </a>
              </li>}
              {pageData.auth.role==="ADMIN"&&<li className="nav-item" role="presentation">
                <a className="nav-link active" href="/admin/admin-dashboard">
                  Dashboard
                </a>
              </li>}
          </ul>
          {!pageData.auth.isLoggedIn&&
          <a href="/login"><button
            className="btn btn-outline-light btn-lg border-primary"
            type="button"
            style={{
              width: "120px",
              height: "34.6667px",
              color: "rgb(43,123,203)",
              "font-size": "12.8px",
              "font-family": "Montserrat, sans-serif",
              "background-color": "rgba(255,255,255,0)",
            }}
          >
            Login
          </button></a>}
          {pageData.auth.isLoggedIn&&
          <a href="/logout"><button
            className="btn btn-danger"
            type="button"
            style={{
              width: "120px",
              height: "34.6667px",
              "font-size": "12.8px",
              "font-family": "Montserrat, sans-serif",
              
            }}
          >
            Logout
          </button></a>}
        </div>
      </div>
    </nav>
  );
};

export const Footer = () => {
  return (
    <div className="footer-dark">
      <footer>
        <div className="container">
          <div className="row">
            {pageData.footer.footerSections.map((el) => (
              <FooterColumn data={el} />
            ))}
          </div>
          <p className="copyright">{pageData.footer.copyrightText}</p>
        </div>
      </footer>
    </div>
  );
};

export const FooterColumn = (props) => {
  return (
    <div className="col-sm-6 col-md-3 item">
      <h3>{props.data.sectionHeader}</h3>
      <ul>
        {props.data.footerLinks.map((el) => (
          <li>
            <a href={el.url}>{el.name}</a>
          </li>
        ))}
      </ul>
    </div>
  );
};
