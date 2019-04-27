import React, {Component} from 'react'
import axios from 'axios'

export default class ViewHackathon extends Component {
    
    constructor(props) {
        super(props)
        this.state = {
            id : 16,
            hackathon: {}
            // eventName : "",
            // description : "",
            // fee : "",
            // minTeamSize : "",
            // maxTeamSize : ""
        }
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/hackathons/${this.state.id}`) 
            .then(response => {
                console.log(response.data)
                if(response.status === 200) {
                    this.setState({
                        hackathon : response.data
                    })
                } 
            })
    }

    render() {
        return(
            <div>
                Id : {JSON.stringify(this.state.hackathon.id)} <br/>
                Name : {JSON.stringify(this.state.hackathon.eventName)} <br/>
                Description : {JSON.stringify(this.state.hackathon.description)} <br/>
                Fee : {JSON.stringify(this.state.hackathon.fee)} <br/>
                Minimum Team Size : {JSON.stringify(this.state.hackathon.minTeamSize)} <br/>
                Maximum Team Size : {JSON.stringify(this.state.hackathon.maxTeamSize)} <br/>
            </div>
        )
    }
}
