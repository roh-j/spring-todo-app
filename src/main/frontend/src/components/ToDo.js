import React from "react";

class ToDo extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.bno}</td>
                <td>{this.props.title}</td>
                <td>{this.props.writer}</td>
                <td>{this.props.updateDate}</td>
            </tr>
        )
    }
}

export default ToDo;