import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';

export default class Signup extends Component {
    constructor(props) {
        super(props)
        this.state = {

            username: "",
            password: "",
            repeatpassword: "",
            email: ""
        }

        this.usernameHandler = this.usernameHandler.bind(this);
        this.passwordHandler = this.passwordHandler.bind(this);
        this.repeatpasswordHandler = this.repeatpasswordHandler.bind(this);
        this.emailHandler = this.emailHandler.bind(this);
    }

    componentWillMount() {
        this.setState({
           
        })
    }

    usernameHandler = (h) => {
        this.setState({username: h.target.value})
    }

    passwordHandler = (h) => {
        this.setState({password: h.target.value})
    }

    repeatpasswordHandler = (h) => {
        this.setState({repeatpassword: h.target.value})
    }

    emailHandler = (h) => {
        this.setState({email: h.target.value})
    }

    submitHandler = (h) => {
        h.preventDefault()
        const data = {
            username: this.state.username,
            password: this.state.password,
            repeatpassword: this.state.repeatpassword,
            email: this.state.email
        }
        console.log("signup: ", data);
        // axios.defaults.withCredentials = true
        axios.post('http://localhost:8080/hackathons', data)
            .then(response => {

                console.log(response.data.id)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })
    }

    render() {
        const openhacklogo = require('../Miscellanous/openhack.png');
        return (
            <div style={{ backgroundColor: "#eceff1" }}>
                <Header />
                <div>
                    <div class="login-form">
                        <div class="main-div">
                            <div class="panel">
                                <img src={openhacklogo} width="75px" height="75px" />
                                <h2>OpenHack</h2><br />
                            </div>
                            <form onSubmit={this.submitHandler}>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="username" placeholder="Username" onChange={this.usernameHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password" onChange={this.passwordHandler} required />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Re-enter Password" onChange={this.repeatpasswordHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email" onChange={this.emailHandler} required/>
                                </div>
                                <br />
                                <button type="submit" class="btn btn-secondary btn-lg btn-block">Sign Up</button><br />
                                <div class="alert alert-info" role="alert">
                                    Have an account? <a href="">Sign in here</a>
                                </div>
                             
                            </form>
                        </div>
                    </div>
                </div>
                <Footer />
            </div >
        )
    }
}
