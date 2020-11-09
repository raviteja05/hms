import React from "react";
import ReactDOM from "react-dom";
class ViewPrescription extends React.Component {
  close() {
    document.getElementById("prescription-modal").style = "display:none";
    document.getElementById("prescription-modal").className = "modal fade";
  }
  render() {
    var prescription = this.props.prescription.data
      ? this.props.prescription.data
      : "";

    return ReactDOM.createPortal(
      <div
        role="dialog"
        tabindex="-1"
        class="modal fade"
        id="prescription-modal"
        style={{ display: "none" }}
      >
        {prescription && (
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title">Prescription</h4>
              </div>
              <div class="modal-body" style={{ height: "350px" }}>
                <p></p>
                <div
                  class="table-responsive border rounded-0"
                  style={{ height: "300px" }}
                >
                  <table class="table">
                    <thead>
                      <tr></tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td style={{ width: "25%" }}>
                          <strong>Doctor</strong>
                        </td>
                        <td style={{ width: "25%" }}>
                          Dr. {prescription.doctorViewData.firstName}{" "}
                          {prescription.doctorViewData.lastName}
                        </td>
                        <td style={{ width: "25%" }}>
                          <strong>Date</strong>
                        </td>
                        <td style={{ width: "25%" }}>{prescription.date}</td>
                      </tr>
                      <tr>
                        <td colspan="2">
                          <strong>Medicine</strong>
                        </td>
                        <td colspan="2">
                          <strong>Dosage</strong>
                        </td>
                      </tr>
                      {prescription.medicines.map((el) => (
                        <tr>
                          <td colspan="2">{el.name}</td>
                          <td colspan="2">{el.dosage}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="modal-footer">
                <button
                  class="btn btn-light"
                  type="button"
                  onClick={(ev) => this.close()}
                  data-dismiss="modal"
                >
                  Close
                </button>
              </div>
            </div>
          </div>
        )}
      </div>,
      document.getElementById("popup")
    );
  }
}

export default ViewPrescription;
