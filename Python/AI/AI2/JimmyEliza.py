sentence = [
    [r'(.*)How are you(.*)',
     ["I am great thank you for asking.  And yourself?",
      "It has been a rough week.",
      "Cant complain.",
      "Good, how about you?"]],

    [r'(.*)how are you(.*)',
     ["I am great thank you for asking.  And yourself?",
      "It has been a rough week.",
      "Cant complain.",
      "Good, how about you?"]],
    
    [r'(.*)sad(.*)',
     ["What makes you so?",
      "Dont be sad.",
      "Hope you feel better.",
      "Thank you for sharing."]],
 
    [r'(.*)mad(.*)',
     ["What makes you so?",
      "Do not be mad.",
      "Hope you feel better.",
      "Thank you for sharing."]],

    [r'(.*)bad(.*)',
     ["What makes you so?",
      "Dont be sad.",
      "Hope you feel better.",
      "Thank you for sharing."]],

    [r'(.*)happy(.*)',
     ["What makes you so?",
      "Im happy to hear it.",
      "Thank you for sharing."]],

    [r'(.*)joyful(.*)',
     ["What makes you so?",
      "I am happy to hear too.",
      "Thank you for sharing."]],

    [r'(.*)good(.*)',
     ["How splendid to hear?",
      "I am happy for you.",
      "That is a relief.",
      "Thank you for sharing."]],

    [r'(.*)great(.*)',
     ["How splendid to hear.",
      "Wow, terrific!",
      "Thank you for sharing."]],

    [r'Sad(.*)',
     ["What makes you so?",
      "Dont be sad.",
      "Hope you feel better.",
      "Thank you for sharing."]],

    [r'Bad(.*)',
     ["What makes you so?",
      "Dont be sad.",
      "Hope you feel better.",
      "Thank you for sharing."]],
    
    [r'Mad(.*)',
     ["What makes you so?",
      "Do not be mad.",
      "Hope you feel better.",
      "Thank you for sharing."]],

    [r'Joyful(.*)',
     ["Thats stupendous news.",
      "I am happy for you.",
      "Thank you for sharing."]],

    [r'Good(.*)',
     ["How splendid to hear?",
      "I am happy for you.",
      "That is a relief.",
      "Thank you for sharing."]],

    [r'Happy(.*)',
     ["How splendid to hear.",
      "Wow, terrific!",
      "Thank you for sharing."]],

    [r'Hello(.*)',
     ["Hello... it is a pleasure to meet you.",
      "Hi there... how are you today fam?",
      "Hello, how are you feeling today friend?"]],

    [r'(.*)hello(.*)',
     ["Hello... it is a pleasure to meet you.",
      "Hi there... how are you today fam?",
      "Hello, how are you feeling friend?"]],
 
    [r'(.*)friend(.*)',
     ["Tell me more about your friends chap.",
      "Who is your best friend?",
      "I will be your friend.",
      "You should really value your relationships!"]],

    [r'(.*)mother(.*)',
     ["Do you love your mother?",
      "Are you still in contact with your mom? You should call her."
      "You should really value your relationships!",]],
 
    [r'(.*)father(.*)',
     ["Do you love your father?",
      "Are you still in contact with your dad? You should call him.",
      "You should really value your relationships!"]],

    [r'(.*)sister(.*)',
      ["Do you love your sister?",
      "Are you still in contact with your sister? You should call her.",
       "You should really value your relationships!"]],
 
    [r'(.*)brother(.*)',
    ["Do you love your brother?",
     "Are you still in contact with your brother? You should call him.",
     "You should really value your relationships!"]],
 
    [r'(.*)child(.*)',
     ["Did you have much fun in your childhood?",
      "When do you want to have kids?",
      "What was your favorite thing about growing up?",
      "How many kids do you want?"]],
 
   [r'(.*)you?',
     ["That is a great question.",
      "Thanks for asking, good."
      "Making my way downtown, walking fast, faces pass and I am homebound.",
      "Splendid.",
      "Capital my dear Watson."]],
    
    [r'(.*)\?',
     ["How should I know?",
      "Are you mocking me?",
      "My answers are very limited, sorry."]],
 
    [r'(.*)thing(.*)',
     ["that is awesome",
      "Well then"]],

    [r'(.*)ing(.*)',
     ["I love to {0}.",
      "You should always {0}.",
      "Well look at you {0}."]],

    [r'bye',
     ["Okay have a good day.",
      "It was nice talking to you.",
      "Take care!",
      "Goodbye!",
      "Talk to you soon",
      "Hope you have a splendid day, it has been a pleasure."]],
    
    [r'(.*)',
     ["Is that it?",
      "I do not understand.",
      "Can you tell me more please?",
      "I didnt quite understand '{0}' can you phrase it differently?",
      "Hmm.",
      "That is hella interesting.",
      "{0}.",
      "So what does that mean to you?",
      "Are you okay?"]]

    
]
 
def user_input():
    name = raw_input("what is your name?")
    sentence = raw_input("Hi, {0} nice to meet you. How are you doing today?") .format(name)
    while True:
        sentence = input("")
        if re.search(r'(bye|goodbye|farewell)', sentence, re.I):
            print(farewell(sentence))
            break
        print (reply(sentence))

def reply(sentence):
    for pattern, responses in replies:
        match = re.match(pattern, sentence.rstrip(".!"))
        if match:
            response = random.choice(replies)
            return random.choice(replies)

def farewell(sentence):
    if (re.search(r'(bye|goodbye|farewell)', sentence, re.I)):
        response = random.choice(bye_response)
        return response


if name = "___main___":
user_input()
