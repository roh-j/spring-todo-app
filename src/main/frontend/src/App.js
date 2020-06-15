import React from 'react';
import './App.css';
import ToDo from './components/ToDo';
import Complete from './components/Complete';
import Header from "./components/Header";
import Write from "./components/Write";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container} from "react-bootstrap";
import {Table} from "react-bootstrap";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            items: [],
        }
    }
    componentDidMount() {
        fetch('http://localhost:8080/react/home')
            .then(response => response.json())
            .then(data => this.setState({
                isLoaded: true,
                items: data,
            }));
    }
    render() {
        const {isLoaded, items} = this.state;
        if (!isLoaded) {
            return <div>Loading...</div>;
        }
        else {
            return (
                <>
                    <Header/>
                    <Container>
                        <h5>해야할 일</h5>
                        <Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                items['todo'].map((item, index) => {
                                    return <ToDo
                                        key={index}
                                        bno={item.bno}
                                        title={item.title}
                                        content={item.content}
                                        writer={item.writer}
                                        regDate={item.regDate}
                                        updateDate={item.updateDate}
                                        isComplete={item.isComplete}/>
                                })
                            }
                            </tbody>
                        </Table>
                        <hr/>
                        <h5>완료한 일</h5>
                        <Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                items['complete'].map((item, index) => {
                                    return <Complete
                                        key={index}
                                        bno={item.bno}
                                        title={item.title}
                                        content={item.content}
                                        writer={item.writer}
                                        regDate={item.regDate}
                                        updateDate={item.updateDate}
                                        isComplete={item.isComplete}/>
                                })
                            }
                            </tbody>
                        </Table>
                        <h5>내용 작성</h5>
                        <hr/>
                        <Write/>
                    </Container>
                </>
            );
        }
    }
}

export default App;
