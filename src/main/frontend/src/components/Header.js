import React from "react";
import {Navbar} from "react-bootstrap";

class Header extends React.Component {
    render() {
        return (
            <>
                <Navbar bg="light" className="border-bottom" variant="shadow-sm mb-3">
                    <Navbar.Brand href="/" className="font-weight-bold">React Demo</Navbar.Brand>
                </Navbar>
            </>
        )
    }
}

export default Header;