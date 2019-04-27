import React, {Component} from 'react'
import {Route} from 'react-router-dom'
import CreateHackathon from './Hackathon/CreateHackathon'
import ViewHackathon from './Hackathon/ViewHackathon'

class RouteFile extends Component {
    render() {
        return(
            <div>
                <Route path="/createHackathon" component={CreateHackathon} />
                <Route path="/hackathonDetails" component={ViewHackathon} />
            </div>
        )
    }
}

export default RouteFile;