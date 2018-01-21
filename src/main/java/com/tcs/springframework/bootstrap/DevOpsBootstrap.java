package com.tcs.springframework.bootstrap;

import com.tcs.springframework.domain.Author;
import com.tcs.springframework.domain.Product;
import com.tcs.springframework.domain.ProductCategory;
import com.tcs.springframework.repositories.AuthorRepository;
import com.tcs.springframework.repositories.ProductCategoryRepository;
import com.tcs.springframework.repositories.ProductRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by at on 5/6/16.
 */
@Component
public class DevOpsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setProductCategoryRepository(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(IteratorUtils.toList(authorRepository.findAll().iterator()).size() == 0) {

            Author at = new Author();
            at.setFirstName("Amit");
            at.setLastName("Tawde");
            at.setId(1);
            at.setImage("instructor_at.png");

            at = authorRepository.save(at);

            ProductCategory devOps = new ProductCategory();
            devOps.setId(1);
            devOps.setCategory("DevOps");

            devOps = productCategoryRepository.save(devOps);

            ProductCategory data = new ProductCategory();
            data.setId(2);
            data.setCategory("Modern Data Platforms");

            data = productCategoryRepository.save(data);

            ProductCategory spring = new ProductCategory();
            spring.setId(3);
            spring.setCategory("Spring");

            spring = productCategoryRepository.save(spring);

            ProductCategory iot = new ProductCategory();
            iot.setId(4);
            iot.setCategory("IoT");

            iot = productCategoryRepository.save(iot);

            Product internetOfThings = new Product();
            internetOfThings.setId(1);
            internetOfThings.setCourseName("Introduction to IoT");
            internetOfThings.setCourseSubtitle("Start Exploring IoT!");
            internetOfThings.setAuthor(at);
            internetOfThings.setCourseDescription("The Internet of things (IoT) is the network of physical devices, vehicles, home appliances and other items embedded with electronics," +
                    " software, sensors, actuators, and network connectivity which enables these objects to connect and exchange data. Each thing is uniquely identifiable through its " +
                    "embedded computing system but is able to inter-operate within the existing Internet infrastructure. Experts estimate that the IoT will consist of about 30 billion" +
                    " objects by 2020. It is also estimated that the global market value of IoT will reach $7.1 trillion by 2020. The IoT allows objects to be sensed or controlled " +
                    "remotely across existing network infrastructure, creating opportunities for more direct integration of the physical world into computer-based systems, and " +
                    "resulting in improved efficiency, accuracy and economic benefit in addition to reduced human intervention. When IoT is augmented with sensors and actuators, the " +
                    "technology becomes an instance of the more general class of cyber-physical systems, which also encompasses technologies such as smart grids, virtual power plants, " +
                    "smart homes, intelligent transportation and smart cities. \"Things\", in the IoT sense, can refer to a wide variety of devices such as heart monitoring implants, " +
                    "biochip transponders on farm animals, cameras streaming live feeds of wild animals in coastal waters, automobiles with built-in sensors, DNA analysis devices for " +
                    "environmental/food/pathogen monitoring, or field operation devices that assist firefighters in search and rescue operations. Legal scholars suggest regarding " +
                    "\"things\" as an \"inextricable mixture of hardware, software, data and service\". These devices collect useful data with the help of various existing technologies " +
                    "and then autonomously flow the data between other devices.");
            internetOfThings.setPrice(new BigDecimal("0"));
            internetOfThings.setImageUrl("IOTThumb.jpg");
            internetOfThings.getProductCategories().add(iot);

            internetOfThings = productRepository.save(internetOfThings);

            Product bigData = new Product();
            bigData.setId(2);
            bigData.setCourseName("Big Data Ultimate");
            bigData.setCourseSubtitle("Ultimate Bundle of Big Data!");
            bigData.setAuthor(at);
            bigData.setCourseDescription("Big data is data sets that are so voluminous and complex that traditional data processing application software are inadequate to deal with them. " +
                    "Big data challenges include capturing data, data storage, data analysis, search, sharing, transfer, visualization, querying, updating and information privacy. There are " +
                    "three dimensions to big data known as Volume, Variety and Velocity. Lately, the term \"big data\" tends to refer to the use of predictive analytics, user behavior " +
                    "analytics, or certain other advanced data analytics methods that extract value from data, and seldom to a particular size of data set. \"There is little doubt that the " +
                    "quantities of data now available are indeed large, but that’s not the most relevant characteristic of this new data ecosystem.\" Analysis of data sets can find new " +
                    "correlations to \"spot business trends, prevent diseases, combat crime and so on.\" Scientists, business executives, practitioners of medicine, advertising and " +
                    "governments alike regularly meet difficulties with large data-sets in areas including Internet search, fintech, urban informatics, and business informatics. Scientists " +
                    "encounter limitations in e-Science work, including meteorology, genomics, connectomics, complex physics simulations, biology and environmental research. Data sets grow " +
                    "rapidly - in part because they are increasingly gathered by cheap and numerous information-sensing Internet of things devices such as mobile devices, aerial (remote " +
                    "sensing), software logs, cameras, microphones, radio-frequency identification (RFID) readers and wireless sensor networks. The world's technological per-capita capacity " +
                    "to store information has roughly doubled every 40 months since the 1980s; as of 2012, every day 2.5 exabytes (2.5×1018) of data are generated. By 2025, IDC predicts " +
                    "there will be 163 zettabytes of data. One question for large enterprises is determining who should own big-data initiatives that affect the entire organization.");
            bigData.setPrice(new BigDecimal("0"));
            bigData.setImageUrl("BigDataThumb.png");
            bigData.getProductCategories().add(data);

            bigData = productRepository.save(bigData);

            Product cloudComputing = new Product();
            cloudComputing.setId(3);
            cloudComputing.setCourseName("Cloud Computing");
            cloudComputing.setCourseSubtitle("Enter The Cloud World!");
            cloudComputing.setAuthor(at);
            cloudComputing.setCourseDescription("Cloud computing is an information technology (IT) paradigm that enables ubiquitous access to shared pools of configurable system resources " +
                    "and higher-level services that can be rapidly provisioned with minimal management effort, often over the Internet. Cloud computing relies on sharing of resources to " +
                    "achieve coherence and economy of scale, similar to a utility. Third-party clouds enable organizations to focus on their core businesses instead of expending resources " +
                    "on computer infrastructure and maintenance. Advocates note that cloud computing allows companies to avoid or minimize up-front IT infrastructure costs. Proponents also " +
                    "claim that cloud computing allows enterprises to get their applications up and running faster, with improved manageability and less maintenance, and that it enables IT " +
                    "teams to more rapidly adjust resources to meet fluctuating and unpredictable business demand. Cloud providers typically use a \"pay-as-you-go\" model, which can lead to " +
                    "unexpected operating expenses if administrators are not familiarized with cloud-pricing models. Since the launch of Amazon EC2 in 2006, the availability of high-capacity " +
                    "networks, low-cost computers and storage devices as well as the widespread adoption of hardware virtualization, service-oriented architecture, and autonomic and utility " +
                    "computing has led to growth in cloud computing.");
            cloudComputing.setPrice(new BigDecimal("0"));
            cloudComputing.setImageUrl("CloudComputingThumb.jpg");
            cloudComputing.getProductCategories().add(data);

            cloudComputing = productRepository.save(cloudComputing);

            Product machineLearning = new Product();
            machineLearning.setId(4);
            machineLearning.setCourseName("Machine Learning");
            machineLearning.setCourseSubtitle("Pattern recognition and computational learning theory in AI!");
            machineLearning.setAuthor(at);
            machineLearning.setCourseDescription("Machine learning is a field of computer science that gives computers the ability to learn without being explicitly programmed. Evolved from the study of " +
                    "pattern recognition and computational learning theory in artificial intelligence, machine learning explores the study and construction of algorithms that can learn from " +
                    "and make predictions on data – such algorithms overcome following strictly static program instructions by making data-driven predictions or decisions,:2 through building " +
                    "a model from sample inputs. Machine learning is employed in a range of computing tasks where designing and programming explicit algorithms with good performance is " +
                    "difficult or infeasible; example applications include email filtering, detection of network intruders or malicious insiders working towards a data breach, optical " +
                    "character recognition (OCR), learning to rank, and computer vision. Machine learning is closely related to (and often overlaps with) computational statistics, which also " +
                    "focuses on prediction-making through the use of computers. It has strong ties to mathematical optimization, which delivers methods, theory and application domains to the " +
                    "field. Machine learning is sometimes conflated with data mining, where the latter subfield focuses more on exploratory data analysis and is known as unsupervised " +
                    "learning.:vii Machine learning can also be unsupervised and be used to learn and establish baseline behavioral profiles for various entities and then used to find " +
                    "meaningful anomalies. Within the field of data analytics, machine learning is a method used to devise complex models and algorithms that lend themselves to prediction; " +
                    "in commercial use, this is known as predictive analytics. These analytical models allow researchers, data scientists, engineers, and analysts to \"produce reliable, " +
                    "repeatable decisions and results\" and uncover \"hidden insights\" through learning from historical relationships and trends in the data.");
            machineLearning.setPrice(new BigDecimal("0"));
            machineLearning.setImageUrl("MachineLearningThumb.jpg");
            machineLearning.getProductCategories().add(data);

            machineLearning = productRepository.save(machineLearning);

            Product devOpsCourse = new Product();
            devOpsCourse.setId(5);
            devOpsCourse.setCourseName("DevOps Dojo");
            devOpsCourse.setCourseSubtitle("Getting Started with DevOps!");
            devOpsCourse.setAuthor(at);
            devOpsCourse.setCourseDescription("DevOps (a clipped compound of \"development\" and \"operations\") is a software engineering culture and practice that aims at unifying " +
                    "software development (Dev) and software operation (Ops). The main characteristic of the DevOps movement is to strongly advocate automation and monitoring at all " +
                    "steps of software construction, from integration, testing, releasing to deployment and infrastructure management. DevOps aims at shorter development cycles, increased " +
                    "deployment frequency, more dependable releases, in close alignment with business objectives.");
            devOpsCourse.setPrice(new BigDecimal("0"));
            devOpsCourse.setImageUrl("DevOpsThumb.jpg");
            devOpsCourse.getProductCategories().add(devOps);

            devOpsCourse = productRepository.save(devOpsCourse);

            Product springCourse = new Product();
            springCourse.setId(6);
            springCourse.setCourseName("Spring Framework 5.0");
            springCourse.setCourseSubtitle("The right stack for the right job.");
            springCourse.setAuthor(at);
            springCourse.setCourseDescription("Developers are constantly challenged with choosing the most effective runtime, programming model and architecture for their application's " +
                    "requirements and team's skill-set. For example, some use cases are best handled by a technology stack based on synchronous blocking I/O architecture while others would " +
                    "be better served by an asynchronous, and non-blocking stack built on the reactive design principles described in the Reactive Streams Specification. Reactive Spring " +
                    "represents a platform wide initiative to deliver reactive support at every level of the development stack—web, security, data, messaging, etc. Spring Framework 5 " +
                    "delivers on this vision by providing a new reactive web stack called, Spring WebFlux, which is offered side-by-side with the traditional Spring MVC web stack. " +
                    "The choice is yours!");
            springCourse.setPrice(new BigDecimal("0"));
            springCourse.setImageUrl("SpringFramework5.0.svg");
            springCourse.getProductCategories().add(spring);

            springCourse = productRepository.save(springCourse);
        }
    }
}
