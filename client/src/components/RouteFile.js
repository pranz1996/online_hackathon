import React, { Component } from 'react'
import { Route } from 'react-router-dom'
import CreateHackathon from './Hackathon/CreateHackathon'
import ViewHackathon from './Hackathon/ViewHackathon'
import Login from './Login/Login';
import Signup from './Login/Signup';
import LandingPage from './Login/LandingPage';
import UserProfile from './User/UserProfile';
import SearchOrganization from './Organization/SearchOrganization';
import CreateOrganization from './Organization/CreateOrganization';
import MyOrganization from './Organization/MyOrganization';
import SearchHackathon from './Hackathon/SearchHackathon';
import MyHackathon from './Hackathon/MyHackathon';
import JudgeHackathon from './Judge/JudgeHackathon';
import ShowEmailSent from './Login/ShowEmailSent';
import AdminHome from './Admin/AdminHome'
import RegisterForHackathon from './Admin/RegisterForHackathon'
import Payment from './Admin/Payment'
import ConfirmEmail from './Admin/ConfirmEmail'
import ConfirmEmailFinal from './Admin/ConfirmEmailFinal'
import Submission from './Hackathon/Submission';
import CreatedOrganization from './Organization/CreatedOrganization';

require("dotenv").config();
class RouteFile extends Component {
  render() {
    return (
      <div>
        <Route exact path="/" component={LandingPage} />
        <Route path="/login" component={Login} />
        <Route path="/signup" component={Signup} />
        <Route path="/landingpage" component={LandingPage} />
        <Route path="/profile" component={UserProfile} />
    
        <Route path="/searchOrganization" component={SearchOrganization} />
        <Route path="/createOrganization" component={CreateOrganization} />
        <Route path="/myOrganization" component={MyOrganization} />
        <Route path="/createdOrganization" component={CreatedOrganization} />


        <Route path="/createHackathon" component={CreateHackathon} />
        <Route path="/searchHackathon" component={SearchHackathon} />

        <Route path="/hackathonDetails" component={ViewHackathon} />
        

        <Route path="/searchHackathon" component={SearchHackathon} />
        <Route path="/myHackathon" component={MyHackathon} />
        <Route path="/judgeHackathon" component={JudgeHackathon} />
        <Route path="/showEmailSent" component={ShowEmailSent} />
        <Route path="/adminHome" component={AdminHome} />
        <Route path="/registerForHackathon" component={RegisterForHackathon} />
        <Route path="/payment" component={Payment} />
        <Route path="/confirmEmail" component={ConfirmEmail} />
        <Route path="/confirmEmailFinal" component={ConfirmEmailFinal} />

        <Route path="/registerForHackathon" component={RegisterForHackathon} />

        <Route path="/submission" component={Submission} />
        
      </div>
    );
  }
}

export default RouteFile;
