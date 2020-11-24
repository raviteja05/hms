import React from "react";
import { connect } from "react-redux";
import { myAppointments } from "../../actions";
import { transform } from "../../utils/utils";
import Axios from "axios";
import { MessageCardInfo } from "../messagecards/bookingsuccess";

class ListAppointments extends React.Component {
  componentDidMount() {
    var user=window.data.auth.user
    var role=window.data.auth.role
    this.props.myAppointments(user,role);
  }
  delete(id){
      Axios.post("/app/ws/delete-appointment?appId="+id).then(res=>window.location.replace("/app/my-appointments"))
  }
  render() {
    
    var role=window.data.auth.role
      
    return (<div
      class="container"
      style={{ position: "relative", "min-height": "50vh" }}
    >
      {this.props.appData.data&&this.props.appData.data.length==0&&<MessageCardInfo message="You have no upcoming appointments"/>}
      {this.props.appData.data &&
          transform(this.props.appData.data).map(el=><div class="row">
      {el.map(el=><div class="col" style={{"max-width": "25%","padding-bottom":"15px"}}>
    <div class="card">
        <div class="card-body">
        
            {role==="CUSTOMER"&&<h4 class="card-title">Appointment with Dr. {el.doctor.firstName} {el.doctor.lastName}</h4>}
            {role==="DOCTOR"&&<h4 class="card-title">Appointment with  {el.customer.firstName} {el.customer.lastName}</h4>}
            <h6 class="text-muted card-subtitle mb-2">{el.date} {el.appointmentTime}</h6></div>
            {role==="CUSTOMER"&&<button class="btn btn-danger" type="button" onClick={(ev)=>{this.delete(el.id)}} style={{"padding-left": "12px","margin-left": "25%","margin-right": "25%","margin-bottom": "10px"}}>Cancel</button>}
            {role==="DOCTOR"&&<a href={`/doc/view-appointment?appId=${el.id}`}><button class="btn btn-primary" type="button" style={{"padding-left": "12px","margin-left": "25%","margin-right": "25%","margin-bottom": "10px"}}>View</button></a>}
    </div>
</div>)}
        </div>)}
    </div>);
  }
}

export const mapStateToProps = (state) => {
  return { appData: state.myAppointments };
};
export default connect(mapStateToProps, { myAppointments })(ListAppointments);
