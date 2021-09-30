<?php

require_once 'include/quiz.php';

$quizObject = new Quiz();

$json_quiz_objects = $quizObject->getAllQuizQuestions();

echo json_encode($json_quiz_objects);

?>
