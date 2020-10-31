import React from "react";
import { connect } from "react-redux";
import { getDoctors } from "../../actions";
import { transform } from "../../utils/utils";

class ListCardContainer extends React.Component {
  componentDidMount() {
    this.props.getDoctors();
  }

  render() {
    return (
      <div className="container">
        {this.props.appData &&
          transform(this.props.appData).map((el) => (
            <div className="card-group">
              {el.map((el) => (
                <div
                  className="card text-center"
                  style={{ "max-width": "25%" }}
                >
                  <div className="card-body">
                    <h4 className="card-title">{`${el.firstName} ${el.lastName}`}</h4>
                    <p className="card-text">
                      {el.designation}
                    </p>
                    <a href={`/app/view-appointments?doctor=${el.email}`}><button className="btn btn-primary" type="button">
                      Select
                    </button></a>
                  </div>
                </div>
              ))}
            </div>
          ))}
      </div>
    );
  }
}
export const mapStateToProps = (state) => {
  return { appData: state.doctors };
};
export default connect(mapStateToProps, { getDoctors })(ListCardContainer);
