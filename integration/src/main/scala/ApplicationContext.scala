/**
 * Created by kbraghubanshi on 7/3/2015.
 */
import com.google.inject.{Binder, Module}
import event.{AkkaEventPublisher, EventPublisher}

class ApplicationContext extends Module {

   def configure(binder: Binder) = {
     binder.bind(classOf[EventPublisher]).to(classOf[AkkaEventPublisher])

   }
 }
