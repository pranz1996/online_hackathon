import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';

export default class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: "",
            password: "",
            successFlag : ""
        }

        this.emailHandler = this.emailHandler.bind(this);
        this.passwordHandler = this.passwordHandler.bind(this);
    }

    componentWillMount() {
        this.setState({
            successFlag : false
        })
    }

    emailHandler = (h) => {
        this.setState({
            email: h.target.value
        })
    }

    passwordHandler = (h) => {
        this.setState({
            password: h.target.value
        })
    }

  
    submitHandler = (h) => {
        h.preventDefault()
        const data = {
            email: this.state.email,
            password: this.state.password
           
        }
        // axios.defaults.withCredentials = true
        axios.post('http://localhost:8080/login', data)
            .then(response => {
                console.log(response)
                console.log(response.status)
                console.log(response.data.user)
                console.log(response.data.token)
                localStorage.setItem('token',response.data.token)
                localStorage.setItem('email',response.data.user)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })
    }

    render() {
        let redirectVar = null
        if(this.state.successFlag) {
            redirectVar = <Redirect to='/user' />
        }
        const openhacklogo = require('../Miscellanous/openhack.png');
        return (
            <div style={{ backgroundColor: "#243e8c" }}>
            {redirectVar}
           <div style={{ backgroundColor: "#243e8c" }}>
                <Header />
                <div style={{ backgroundColor: "#243e8c" }}>
                    <div class="login-form">
                        <div class="main-div">
                            <div class="panel">
                                <img src={openhacklogo} width="75px" height="75px" />
                                <h2>OpenHack</h2><br /><br/>
                            </div>
                            <form onSubmit={this.submitHandler}>
                            <div class="form-group">
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email" onChange={this.emailHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password" onChange={this.passwordHandler} required/>
                                </div>
                                <br />
                                <button type="submit" class="btn btn-secondary btn-lg btn-block">Login</button><br />
                                <div class="alert alert-info" role="alert">
                                    Create an account <a href="/signup">Sign up here</a>
                                </div>
                    
                            </form>
                        </div>
                        </div>
                    </div>
                    <Footer />
                </div >
                </div>
                )
            }
        }
