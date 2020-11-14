import {Header,Footer} from '../component-library/common'
import {HeroBanner,FeatureCardContainerComponent} from '../component-library/home'
import LoginComponent from '../component-library/auth/Login'
import RegisterFormComponent from '../component-library/auth/Register'
import ContactFormComponent from '../component-library/contact/contact'
import {DashBoardContainer} from '../component-library/dashboard/DashBoardContainer'
import {ErrorComponent} from '../component-library/error/error'
import AppointmentDashboard from '../component-library/appointment/AppointmentDashboard'
import PatientPrescriptionsList from '../component-library/appointment/PatientPrescriptionsList'
import ListCardContainer from '../component-library/listcardcontainer/ListCardContainer'
import ListAppointments from '../component-library/listcardcontainer/ListAppointments'
import {BookingSuccess} from '../component-library/messagecards/bookingsuccess'
import ViewAppointment from '../component-library/view-appointment/ViewAppointment'
import EditProfile from '../component-library/editprofile'
export const pageComponents={
    home:[Header,HeroBanner,FeatureCardContainerComponent,Footer],
    login:[Header,LoginComponent,Footer],
    signup:[Header,RegisterFormComponent,Footer],
    contact:[Header,ContactFormComponent,Footer],
    dashboard:[Header,DashBoardContainer,Footer],
    error:[Header,ErrorComponent,Footer],
    "view-appointments":[Header,AppointmentDashboard,Footer],
    "view-doctors":[Header,ListCardContainer,Footer],
    "booking-success":[Header,BookingSuccess,Footer],
    "my-appointments":[Header,ListAppointments,Footer],
    "view-appointment":[Header,ViewAppointment,Footer],
    "my-prescriptions":[Header,PatientPrescriptionsList,Footer],
    "profile":[Header,EditProfile,Footer]
    

}