import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';

export default class Submission extends Component {
    constructor(props) {
        super(props)
        this.state = {
            submission_url : "",
            successFlag: false
        }
        this.submissionHandler = this.submissionHandler.bind(this)
    }

    componentWillMount() {
        this.setState({
            successFlag: false
        })
    }

    submissionHandler = (h) => {
        this.setState({
            submission_url: h.target.value
        })
    }

    submitHandler = (h) => {
        h.preventDefault()

        const data = {
            submission_link : this.state.submission_url
        }
        // axios.defaults.withCredentials = true
        axios.post(`http://localhost:8080/teams/submission/${1}`, data)
            .then(response => {
                console.log(" response " + response.data)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })
    }

    render() {
        let redirectVar = null
        if (this.state.successFlag) {
            redirectVar = <Redirect to="/searchHackathon" />
        }
        return (
            <div style={{ backgroundColor: "#f2f2f2" }}>
                {redirectVar}
                <Header />
                <div>


                    <div>
                        <div class="hackathon-login-form">
                            <div class="hackathon-main-div">
                                <div class="hackathon-panel">
                                    {/* <img src={openhacklogo} width="75px" height="75px" /> */}
                                    <h2>Submission For A Hackathon</h2><br />
                                </div>
                                <form onSubmit={this.submitHandler}>
                                    
                                    <div class="form-group">
                                        <input name="description" class="form-control" type="text" placeholder=" Enter the GitHub Url" onChange={this.submissionHandler} required />
                                    </div>


                                   
                                    <button type="submit" class="btn btn-secondary btn-lg btn-block">Submit</button><br />
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
                <Footer />
            </div>
        )
    }
}
