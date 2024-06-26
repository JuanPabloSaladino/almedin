package Config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.License;
import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="widget", description="Widget operations."),
                @Tag(name="gasket", description="Operations related to gaskets")
        },
        info = @Info(
                title="API ObraSocial test",
                version = "1.0.1",
                contact = @Contact (
                        name = "API UMSA OBRA-SOCIAL",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)

public class CustomApi extends Application {


}
