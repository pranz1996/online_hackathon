import React, {Component} from 'react'
import {Route} from 'react-router-dom'
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

require('dotenv').config();
class RouteFile extends Component {
    render() {
        return(
            <div>
                
                <Route path="/createHackathon" component={CreateHackathon} />
                <Route path="/hackathonDetails" component={ViewHackathon} />
                <Route path="/login" component={Login}/>
                <Route path="/signup" component={Signup}/>
                <Route path="/landingpage" component={LandingPage}/>
                <Route path="/user" component={UserProfile}/>
                <Route path="/searchOrganization" component={SearchOrganization}/>
                <Route path="/createOrganization" component={CreateOrganization}/>
                <Route path="/myOrganization" component={MyOrganization}/>
                <Route path="/searchHackathon" component={SearchHackathon}/>
                <Route path="/myHackathon" component={MyHackathon}/>
                  
            </div>
        )
    }
}

export default RouteFile;