import React from "react";
import {Card} from "react-bootstrap";
import {Button} from "react-bootstrap";
import {Form} from "react-bootstrap";

class Write extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: '',
            content: '',
            writer: '',
        }

        this.onSubmitHandler = this.onSubmitHandler.bind(this); // Form Data를 바인딩하여야 this.state에 접근할 수 있음
    }
    onChangeHandler = (event) => {
        let name = event.target.name;
        let value = event.target.value;

        this.setState({[name]: value});
    }
    onSubmitHandler(event) {
        event.preventDefault();
        console.log(this.state);

        fetch('http://localhost:8080/react/insert', {
            method: 'POST',
            body: JSON.stringify(this.state),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => console.log(response));
    }
    render() {
        return (
            <Card className="max-width">
                <Card.Header>내용 작성란</Card.Header>
                <Card.Body>
                    <Form onSubmit={this.onSubmitHandler}>
                        <Form.Group controlId="write.title">
                            <Form.Label>제목</Form.Label>
                            <Form.Control type="text" name="title" onChange={this.onChangeHandler} />
                        </Form.Group>
                        <Form.Group controlId="write.content">
                            <Form.Label>내용</Form.Label>
                            <Form.Control as="textarea" rows="5" name="content" onChange={this.onChangeHandler} />
                        </Form.Group>
                        <Form.Group controlId="write.writer">
                            <Form.Label>작성자</Form.Label>
                            <Form.Control type="text" name="writer" onChange={this.onChangeHandler} />
                        </Form.Group>
                        <Button type="submit">등록</Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}

export default Write;