# scala-ddd-cqrs

##Command
Command represents requested to perform some action by the system. All commands should extend from Command class. A command handler (extending from CommandHandler) can handle multiple commands. HandlersProvider will register all the command handlers and provide method to lookup correct handler for a command. The CommandBus is responsible for dispatching the command to its handler.

##Event
Events are result of the action which are already happened. All events should inherit from DomainEvent class. EventHandler subscribes DomainEvent from the EventBus and is responsible for handling that event. Akka Actor subscribing Event into EventBus. DefaultEventPublisher will lookup event handler and executes it. The better EventPublisher will publish into bus (example: publish into AKKA EventBus).

In this project I've utilized events to de-couple the modules. When any command is handled by CommandHandler, sometime it needs to execute something from external bounded context. Example: when a payment is made, generate the invoice. In this case, event "PaymentMade" will be published and subscribing handler will create Invoice, externally.
