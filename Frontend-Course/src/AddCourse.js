import React, { useState } from 'react';
import { TextField, Button, Box, Typography } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddCourse = () => {
    const navigate = useNavigate();

    const [courseData, setCourseData] = useState({
        title: '',
        description: '',
        price: '',
    });

    const handleChange = (e) => {
        setCourseData({ ...courseData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/cou", courseData);
            navigate('/'); 
        } catch (err) {
            console.error("Error adding course:", err);
        }
    };

    return (
        <Box
            display="flex"
            flexDirection="column"
            alignItems="center"
            justifyContent="center"
            minHeight="100vh"
            padding={4}
        >
            <Typography variant="h4" gutterBottom>
                Add New Course
            </Typography>
            <Box
                component="form"
                onSubmit={handleSubmit}
                noValidate
                sx={{ width: '100%', maxWidth: 500 }}
            >
                <TextField
                    fullWidth
                    label="Title"
                    name="title"
                    value={courseData.title}
                    onChange={handleChange}
                    margin="normal"
                    required
                />
                <TextField
                    fullWidth
                    label="Description"
                    name="description"
                    value={courseData.description}
                    onChange={handleChange}
                    margin="normal"
                    multiline
                    rows={4}
                    required
                />
                <TextField
                    fullWidth
                    label="Price"
                    name="price"
                    value={courseData.price}
                    onChange={handleChange}
                    margin="normal"
                    type="number"
                    required
                />
                <Box marginTop={2} display="flex" justifyContent="space-between">
                    <Button
                        variant="contained"
                        color="primary"
                        type="submit"
                    >
                        Submit
                    </Button>
                    <Button
                        variant="outlined"
                        color="secondary"
                        onClick={() => navigate('/')}
                    >
                        Cancel
                    </Button>
                </Box>
            </Box>
        </Box>
    );
};

export default AddCourse;
