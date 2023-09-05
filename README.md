# ManageMyEvents - Spring Boot Application

## Description

ManageMyEvents is a Spring Boot application for managing various types of events. It allows you to list, view, add, update, and delete events. The application uses MongoDB for the backend data storage and provides a clean web interface using Thymeleaf templates.
<img width="1430" alt="Screenshot 2023-09-04 at 9 32 05 PM" src="https://github.com/NatalioF22/ManageMyEvents/assets/116610989/54a20c98-c461-471e-a44a-9a094321d249">


## Features

- List all events
- View details of a specific event
- Add a new event
- Update an existing event
- Delete an event

## Prerequisites

1. Java 11+
2. Maven 3.x
3. MongoDB 4.x

## Installation and Setup

1. **Clone the repository**

    ```
    git clone https://github.com/NatalioF22/ManageMyEvents.git
    ```

2. **Navigate to the directory**

    ```
    cd ManageMyEvents
    ```

3. **Build the project using Maven**

    ```
    mvn clean install
    ```

4. **Run the Spring Boot application**

    ```
    mvn spring-boot:run
    ```

5. **Access the application**

    Open your browser and navigate to `http://localhost:8080`

## API Endpoints and Web Routes

1. **List all Events**: `GET /`
2. **View a Specific Event**: `GET /events/{id}`
3. **Add a New Event**: `GET /addEvent` (Form) & `POST /addEvent` (Submit Form)
4. **Update an Existing Event**: `GET /updateEvent/{id}` (Form) & `POST /updateEvent/{id}` (Submit Form)
5. **Delete an Event**: `POST /events/delete/{id}`

## Code Structure Highlights

- `EventController.java`: This is the main controller that handles all the web requests.
  - It uses `EventService` for business logic and `EventRepository` for data operations.
  - The controller also uses `DataLoader` for preloading data if needed.

### EventController.java Snippets

- **Get All Events**: Retrieves all events and displays them on the index page.

    ```java
    @GetMapping("/")
    public String getAllEvents(Model model) {
        List<Event> events = service.getAllEvents();
        model.addAttribute("events", events);
        return "index";
    }
    ```

- **Add a New Event**: Allows adding a new event through a form.

    ```java
    @PostMapping("/addEvent")
    public String submitForm(@RequestParam String eventName, /* Other params */) {
        // Business logic
        return "redirect:/";
    }
    ```

- **Update an Existing Event**: Allows updating an existing event.

    ```java
    @PostMapping("/updateEvent/{id}")
    public String updateEvent(@PathVariable String id, /* Other params */) {
        // Business logic
        return "redirect:/";
    }
    ```

## Logging

- Uses SLF4J for logging.
- Logs are saved in `./logs` directory.

```java
private static final Logger logger = LoggerFactory.getLogger(EventController.class);
```

## Contributing

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit.
4. Push to your branch.
5. Create a Pull Request.


