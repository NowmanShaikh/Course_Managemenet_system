import { Card, CardContent, Typography, Grid, Button, Box } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Home = () => {
    const [courses, setCourses] = useState([]);
    const [initialLoading, setInitialLoading] = useState(true);

    const nav = useNavigate();

    useEffect(() => {
        const fetchCourses = async () => {
            try {
                const response = await axios.get("http://localhost:8080/cou");
                setCourses(response.data.data);
            } catch (err) {
                console.error(err);
            }
        };

        if (initialLoading) {
            fetchCourses();
            setInitialLoading(false);
        }
    }, [initialLoading]);

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/cou/del/${id}`);
            setCourses((prevCourses) => prevCourses.filter((course) => course.id !== id));
            setInitialLoading(true);

        } catch (err) {
            console.error("Error deleting course:", err);
        }
    };

    return (

        <Card
            variant="outlined"
            sx={{
                width: "80%",
                margin: "auto",
                marginY: 2,
            }}>
            <Box style={{ padding: '20px' }}>
                <Box display="flex" justifyContent="space-between" marginBottom="30px">
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => { nav("/add-course") }}
                    >
                        Add New Course
                    </Button>
                </Box>

                <Grid container spacing={2}>
                    {courses.map((course) => (
                        <Grid item xs={12} sm={6} md={4} lg={3} key={course.id}>
                            <Card>
                                <CardContent sx={{height:"250px"}}>
                                    <Typography variant="h6" component="div" gutterBottom>
                                        {course.title}
                                    </Typography>
                                    <Typography variant="body2" color="textSecondary">
                                        {course.description}
                                    </Typography>
                                    <Typography variant="h6" color="primary" style={{ marginTop: '10px' }}>
                                        ₹{course.price.toFixed(2)}
                                    </Typography>
                                    <Box
                                        display="flex"
                                        justifyContent="space-between"
                                        marginTop="20px"
                                    >
                                        <Button
                                            variant="outlined"
                                            color="primary"
                                            onClick={() => nav(`/edit-course/${course.id}`)}
                                        >
                                            Update
                                        </Button>
                                        <Button
                                            variant="contained"
                                            color="secondary"
                                            onClick={() => handleDelete(course.id)}
                                        >
                                            Delete
                                        </Button>
                                    </Box>
                                </CardContent>
                            </Card>
                        </Grid>
                    ))}
                </Grid>
            </Box>
        </Card>

    );
};

export default Home;
