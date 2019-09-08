# lifecycle

## Lifecycle in Spring

### Load bean definitions

#### Bean Definitions Loaded
* The ```@Configuration``` classes are processed

    * And/or ``` @Components``` are scanned for
    * And/or XML files are parsed

* Bean definitions added to ```BeanFactory```
    * Each indexed under its id
    
#### Post Process Bean Definitions

* Special ```BeanFactoryPostProcessor``` beans invoked
    * Can modify the definition of any bean
    
* Applies transformations to bean definitions
    * Before objects are actually created
    
* Several useful implementations provided in Spring
    * You can write your own (not common)
    * Implement ```BeanFactoryPostProcessor``` interface


### Initialize bean instances (Instantiate Beans, Setters Called)

* Each bean is eagerly instantiated by default
    * Created in right order with its dependencies injected
* After dependency injection each bean goes through a post-processing phase
    * Further configuration and initialization may occur
* After post processing the bean is fully initialized and ready for use
    * Tracked by its id until the context is destroyed

* Set Bean Name: If the bean implements ```BeanNameAware``` interface, spring passes the bean’s id to ```setBeanName()``` method.
* Set Bean factory: If Bean implements ```BeanFactoryAware``` interface, spring passes the ```beanfactory``` to ```setBeanFactory()``` method.

### Bean Post Processing

```BeanPostProcessor``` -> ```InitializingBean``` -> ```BeanPostProcessor```

* Pre Initialization: Also called post process of bean. If there are any bean ```BeanPostProcessor``` associated with the bean, Spring calls ```postProcesserBeforeInitialization()``` method.
* Initialize beans: If the bean implements ```InitializingBean```,its ```afterPropertySet()``` method is called. If the bean has init method declaration, the specified initialization method is called.
* Post Initialization: – If there are any BeanPostProcessors associated with the bean, their ```postProcessAfterInitialization()``` methods will be called.

### Bean ready for use

Now the bean is ready to use by the application, 99,99% application in here!

#### Destruction

* If the bean implements ```DisposableBean``` , it will call the ```destroy()``` method
* Or use ```@PreDestroy```
