import React from 'react'
import {connect} from 'react-redux'
class EditProfile extends React.Component{
    render(){

        var role=window.data.auth.role
        return (
            <div class="container">
        <div class="table-responsive table-borderless">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th colspan="4">Edit Profile</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" required=""/></td>
                        <td>Last Name</td>
                        <td><input type="text" required=""/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" required=""/></td>
                        <td>Phone No</td>
                        <td><input type="tel" required=""/></td>
                    </tr>
                   {role=="CUSTOMER"&& <tr>
                        <td>Age</td>
                        <td><input type="number" max="110" min="0" required=""/></td>
                        <td>Blood Group</td>
                        <td><input type="text"/></td>
                    </tr>}
                    <tr>
                        <td>Change Password</td>
                        <td><input type="password"/></td>
                        <td>Confirm Password</td>
                        <td><input type="password"/></td>
                    </tr>
                    {role=="DOCTOR"&& <tr>
                        <td>Designation</td>
                        <td><input type="text"/></td>
                        <td>Specialization</td>
                        <td><input type="text"/></td>
                    </tr>}
                    <tr>
                        <td>Address</td>
                        <td colspan="3"><textarea cols="50"></textarea></td>
                    </tr>
                    {role=="CUSTOMER"&& <tr>
                        <td>Known Allergies</td>
                        <td colspan="3"><textarea cols="50"></textarea></td>
                    </tr>}
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><button class="btn btn-primary" type="button">Save</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
        )

    }

    
}
const mapStateToProps=(state)=>{
    return {data:state}
}

export default connect(mapStateToProps)(EditProfile);