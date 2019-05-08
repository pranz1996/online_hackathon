import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';


export default class UserProfile extends Component {
    constructor(props) {
        super(props)
        this.state = {
            businesstitle: "",
            address: "",
            city: "",
            state: "",
            zip: "",
            aboutme: ""
        }

        this.businesstitleHandler = this.businesstitleHandler.bind(this);
        this.addressHandler = this.addressHandler.bind(this);
        this.cityHandler = this.cityHandler.bind(this);
        this.stateHandler = this.stateHandler.bind(this);
        this.zipHandler = this.zipHandler.bind(this);
        this.aboutmeHandler = this.aboutmeHandler.bind(this);
    }


    componentDidMount() {
        console.log("hello", this.props);

        // axios.get('http://localhost:8080/jeaselte', { params: { data: data } })
        //     .then((response) => {
        //         //console.log("Status Code : ",response.data);
        //         if (response.data === 400) {
        //             window.location = "/ownerlogin"
        //         }
        //         console.log("in get")
        //         console.log(response)
        //         this.loadData(response);
        //     });

    }

    componentWillMount() {
        this.setState({
        })
    }

    businesstitleHandler = (h) => {
        this.setState({
            businesstitle: h.target.value
        })
    }

    addressHandler = (h) => {
        this.setState({
            address: h.target.value
        })
    }

    cityHandler = (h) => {
        this.setState({
            city: h.target.value
        })
    }
    stateHandler = (h) => {
        this.setState({
            address: h.target.value
        })
    }
    zipHandler = (h) => {
        this.setState({
            zip: h.target.value
        })
    }
    aboutmeHandler = (h) => {
        this.setState({
            aboutme: h.target.value
        })
    }

    submitHandler = (h) => {
        h.preventDefault();

        const data = {

            businesstitle: this.state.businesstitle,
            address: this.state.address,
            city: this.state.city,
            state: this.state.state,
            zip: this.state.zip,
            aboutme: this.aboutmeHandler
        }
        console.log(data);
        axios.post('http://localhost:8080/users', data)
            .then(response => {
                console.log(" response : ", response)
                console.log(" response status : ", response.status)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })
    }

    render() {
        var emailfromprops = this.props.location.state.email;
        console.log(emailfromprops);
        return (
            <div style={{ backgroundColor: "#243e8c" }}>
                <div style={{ backgroundColor: "#243e8c" }}>
                    <Header />
                    <div style={{ backgroundColor: "#243e8c" }}>
                        <div class="login-form">
                            <div class="user-div">
                                <b><h2>Profile</h2></b><hr />
                                {/* <div class="row">
                                    <img src="" width="100px" height="100px" />
                                    <div class="col">
                                        <input type="file" class="form-control-file" id="exampleFormControlFile1" /><br />
                                        <button type="button" class="btn btn-outline-primary btn-sm btn-block">Upload</button>
                                        <a href="#" class="toggle">(edit profile)</a>
                                    </div>
                                </div> */}
                                <br />

                                <form onSubmit={this.submitHandler}>

                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="staticEmail">Email</label>
                                            {/* <div class="col-sm-10">
                                                <input type="text" readonly class="form-control-plaintext" id="staticEmail" value={JSON.parse(JSON.stringify(emailfromprops)})/>
                                            </div> */}
                                            {/* <input type="email" class="form-control" id="inputEmail4" placeholder="Email" readonly></input> */}
                                            <input type="text" readonly class="form-control-plaintext" id="staticEmail" value={emailfromprops}></input>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="input">Username</label>
                                            <input type="text" class="form-control" id="inputPassword4" placeholder="Username" />
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="input">Business Title</label>
                                            <input type="text" name="businesstitle" class="form-control" id="inputPassword4" placeholder="Business Title" onChange={this.businesstitleHandler} />
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputAddress">Address</label>
                                            <input type="text" name="address" class="form-control" id="inputAddress" placeholder="1234 Main St" onChange={this.addressHandler} />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="inputCity">City</label>
                                            <input type="text" name="city" class="form-control" id="inputCity" onChange={this.cityHandler} />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="inputCity">State</label>
                                            <input type="text" name="state" class="form-control" id="inputState" onChange={this.stateHandler} />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="inputZip">Zip</label>
                                            <input type="text" name="zip" class="form-control" id="inputZip" onChange={this.zipHandler} />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleFormControlTextarea1">About Me</label>
                                        <textarea name="aboutme" class="form-control" id="exampleFormControlTextarea1" rows="4" onChange={this.aboutmeHandler}></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">Update</button><br />
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
