package contact

import contact.Contact._
import play.api.libs.json.{JsValue, Json}

/**
 * Created by kbraghubanshi on 6/29/2015.
 */
class ContactQuery {

     def getContacts: List[JsValue] = {
        val contacts: List[Contact] = ContactRepository.getAll()
        contacts.map(t => Json.toJson(t))
     }

}
